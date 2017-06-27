# ViewPagerFragement
VIewpager实现图片（Fragment的轮播）


![效果图](https://github.com/jakera123/ViewPagerFragement/blob/master/app/src/main/res/drawable/finally.gif)


这里实现了简单的轮播，这里面还有一个BUG，就是当用手是触摸时，底下的图片没有进行改变，方案是，监听TOuch然后去更新位置。还有播到最后一个返回时，有没有可能可以无限向右重播？？？
另外，这里是创建了很多的Fragment，可否考虑，用其他方法来封装一个可以方便使用的轮播效果！定义一个VIew，然后只需要在XML里声明，然后就可以在代码中Add view，即可方便实现轮播！！！！
