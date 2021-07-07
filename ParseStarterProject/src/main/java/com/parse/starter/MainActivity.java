/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.parse.starter;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.parse.ParseAnalytics;


public class MainActivity extends AppCompatActivity {

  Animation topAnim,bottomAnim;
  ImageView img;
  TextView letUs;
  TextView burden;

  private static int Splash_Screen=5000;

    @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
      setContentView(R.layout.activity_main);

      topAnim= AnimationUtils.loadAnimation(this,R.anim.top_animation);
      bottomAnim= AnimationUtils.loadAnimation(this,R.anim.bottom_animation);
      img=findViewById(R.id.img);
      letUs=findViewById(R.id.letUs);
      burden=findViewById(R.id.burdenText);
      img.setAnimation(topAnim);
      letUs.setAnimation(bottomAnim);
      burden.setAnimation(bottomAnim);


      new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {
          Intent intent=new Intent(MainActivity.this,SelectActivity.class);
          startActivity(intent);
          finish();

        }
      },Splash_Screen);

    ParseAnalytics.trackAppOpenedInBackground(getIntent());
  }

}
