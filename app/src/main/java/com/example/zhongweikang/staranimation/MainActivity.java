package com.example.zhongweikang.staranimation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
     private RelativeLayout relativeLayout;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        relativeLayout= (RelativeLayout) findViewById(R.id.relativeLayout);
        imageView= (ImageView) findViewById(R.id.xiaohai);
        AnimationSet animationSet=new AnimationSet(true);// 动画集合
        animationSet.setDuration(5000);  // 设置集合的持续时间
        AlphaAnimation alphaAnimation=new AlphaAnimation(0,1); // 设置透明度由无到有
        alphaAnimation.setDuration(5000);// 透明度动画持续时间
        animationSet.addAnimation(alphaAnimation); // 将透明度的效果设置到动画集合中
        relativeLayout.startAnimation(animationSet);
        ScaleAnimation scaleAnimation=new ScaleAnimation(0,1,0,1, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f); //缩放动画
        scaleAnimation.setDuration(5000);
        RotateAnimation rotateAnimation=new RotateAnimation(0,360,RotateAnimation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);// 旋转动画
        rotateAnimation.setDuration(5000);
        AnimationSet a=new AnimationSet(true);
        a.addAnimation(rotateAnimation);//添加
        a.addAnimation(scaleAnimation);
        imageView.startAnimation(a);
       alphaAnimation.setAnimationListener(new Animation.AnimationListener() { // 为动画设置监听事件
           @Override
           public void onAnimationStart(Animation animation) {

           }
           @Override
           public void onAnimationEnd(Animation animation) {//透明动画结束的时候跳转界面
               Intent intent=new Intent(MainActivity.this,Main2Activity.class);
               startActivity(intent);
               finish();
           }
           @Override
           public void onAnimationRepeat(Animation animation) {
           }
       });

    }
}
