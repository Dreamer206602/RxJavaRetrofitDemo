**在开发中实现点击WebView中的图片,调用原生的控件放大展示**

实现原理如下:

1.首先加载一个html网页,网址或者本地的html文件都可以。
2.遍历html标签源代码,找到所有的img标签的节点。
3.给 遍历的img标签节点加上onClick
4.通过点击加上的onClick事件,通过JS调用原生控件,展示放大即可。


代码如下:
**设置WebView**

    mWebView= (WebView) findViewById(webView);
            WebSettings settings =
                    mWebView.getSettings();
            /**
             * 设置和JS交互的权限
             */
            settings.setJavaScriptEnabled(true);

            /**
             * 允许JS弹窗
             */
            settings.setJavaScriptCanOpenWindowsAutomatically(true);



            //防止中文的乱码
            settings.setDefaultTextEncodingName("UTF-8");


            mWebView.loadUrl("http://www.toutiao.com/a6401738581286682881/#p=1");


            //载入js
            mWebView.addJavascriptInterface(new JavascriptInterface(this), "imagelistner");


关键的代码是:
        mWebView.addJavascriptInterface(new JavascriptInterface(this), "imagelistner");


这行代码就是 WebView 与 JavaScript 交互的关键。
上面两个参数，一个是 JS 接口，一个是监听函数的名字。

遍历img节点,加入监听

    mWebView.setWebViewClient(new WebViewClient(){
                @Override
                public void onPageFinished(WebView view, String url) {
                    super.onPageFinished(view, url);


                    //这段js函数的功能就是注册监听，遍历所有的img标签，并添加onClick函数，函数的功能是在图片点击的时候调用本地java接口并传递url过去
                    mWebView.loadUrl("javascript:(function(){"
                            + "var objs = document.getElementsByTagName(\"img\"); "
                            + "for(var i=0;i<objs.length;i++)  " + "{"
                            + "    objs[i].onclick=function()  " + "    {  "
                            + "        window.imagelistner.openImage(this.src);  "
                            + "    }  " + "}" + "})()");



                }
            });

这里就是给每个 img 节点加入点击事件，注意看这个imagelistenr其实就是 mWebView.addJavascriptInterface(new JavascriptInterface(this), "imagelistner") 定义的方法名，而 openImage 就是我们自定义的 JavaScriptInterface 中的 openImage 方法。

通过 JS 接口，调用原生控件

            // js通信接口

            public class JavascriptInterface {
                private Context context;
                public JavascriptInterface(Context context) {
                    this.context = context;
                }

                @android.webkit.JavascriptInterface
                public void openImage(String img) {
                    Intent intent = new Intent();
                    intent.putExtra("img", img);
                    intent.setClass(context, ImageActivity.class);
                    context.startActivity(intent);
                    System.out.println(img);
                }
            }
这里的 JavascriptInterface 就是和 mWebView.addJavascriptInterface(new JavascriptInterface(this), "imagelistner") 中的 new JavascriptInterface(this) 对应的。这样我们就通过 JavascriptInterface 就把 JS 和 WebView 之间实现通信了。


