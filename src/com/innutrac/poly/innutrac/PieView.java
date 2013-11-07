package com.innutrac.poly.innutrac;

import com.innutrac.poly.innutrac.PieWedge;
import com.innutrac.poly.innutrac.R;
import com.innutrac.poly.innutrac.R.drawable;
import com.innutrac.poly.innutrac.UserInfoActivity;

import android.content.Context;
import android.view.Display;
import android.graphics.Point;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class PieView extends View {
	private int drawMode;
	private Bitmap overlayBitmap;
	private int overlayWidth;

	public PieView(Context context) {
		super(context);
		overlayBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.piechart_shade, null);
		// scale bitmap appropriately
		int h = getHeight();
//		int w = getWidth();
//		System.out.println("Height: " + h + " width: " + w);
		overlayWidth = overlayBitmap.getWidth();
		setLayoutParams(new LayoutParams(overlayWidth, overlayWidth));
	}

	public PieView(Context context, AttributeSet attrs) {
        super(context, attrs);
	}
	
	@Override 
    protected void onDraw(Canvas canvas) {
    	super.onDraw(canvas);   
    	Paint mBgPaints = new Paint();
    	mBgPaints.setAntiAlias(true);
    	mBgPaints.setStyle(Paint.Style.FILL); // look further into this
    	mBgPaints.setColor(Color.BLUE);
    	mBgPaints.setStrokeWidth(0.5f);
    	
    	// Here there will be a data fetch for 8 proportion values (percentages)
    	// The following is sample data:
    	float greenVal, blueVal, purpleVal, pinkVal, redVal, orangeVal, yellowVal, drkGreenVal;
    	greenVal = 11;
    	blueVal = 20;
    	purpleVal = 11;
    	pinkVal = 12;
    	redVal = 8;
    	orangeVal = 20;
    	yellowVal = 8;
    	drkGreenVal = 10;
    	
    	greenVal = (greenVal / 100) * 360;
    	blueVal = (blueVal / 100) * 360;
    	purpleVal = (purpleVal / 100) * 360;
    	pinkVal = (pinkVal / 100) * 360;
    	redVal = (redVal / 100) * 360;
    	orangeVal = (orangeVal / 100) * 360;
    	yellowVal = (yellowVal / 100) * 360;
    	drkGreenVal = (drkGreenVal / 100) * 360;
    	
    	float angle = 360;
    	
    	// Wedge data allocation
    	angle -= greenVal;
    	PieWedge green = new PieWedge(angle, greenVal, "#07B708");
    	angle -= blueVal;
    	PieWedge blue = new PieWedge(angle, blueVal, "#0083FC");
    	angle -= purpleVal;
    	PieWedge purple = new PieWedge(angle, purpleVal, "#8907B4");
    	angle -= pinkVal;
    	PieWedge pink = new PieWedge(angle, pinkVal, "#FCA8F1");
    	angle -= redVal;
    	PieWedge red = new PieWedge(angle, redVal, "#EC0808");
    	angle -= orangeVal;
    	PieWedge orange = new PieWedge(angle, orangeVal, "#F89F28");
    	angle -= yellowVal;
    	PieWedge yellow = new PieWedge(angle, yellowVal, "#F8F628");
    	angle -= drkGreenVal;
    	
    	Paint tPaint = new Paint();
    	tPaint.setAlpha(0);
    	canvas.drawColor(tPaint.getColor());
    	
    	RectF mOvals = new RectF( 7, 7, overlayWidth-7, overlayWidth-7);
    	
    	if(drawMode == 1)
    	{
    		// dark green
    		mBgPaints.setColor(Color.parseColor(green.getColor())); 
	    	canvas.drawArc(mOvals, green.getStartAngle(), green.getSweep(), true, mBgPaints);
	    	
	    	// blue
	    	mBgPaints.setColor(Color.parseColor(blue.getColor()));
	    	canvas.drawArc(mOvals, blue.getStartAngle(), blue.getSweep(), true, mBgPaints);
	    	
	    	// purple
	    	mBgPaints.setColor(Color.parseColor(purple.getColor())); 
	    	canvas.drawArc(mOvals, purple.getStartAngle(), purple.getSweep(), true, mBgPaints);
	    	
	    	// pink
	    	mBgPaints.setColor(Color.parseColor(pink.getColor()));
	    	canvas.drawArc(mOvals, pink.getStartAngle(), pink.getSweep(), true, mBgPaints);
	    	
	    	// red
	    	mBgPaints.setColor(Color.parseColor(red.getColor()));
	    	canvas.drawArc(mOvals, red.getStartAngle(), red.getSweep(), true, mBgPaints);
	    	
	    	// orange
	    	mBgPaints.setColor(Color.parseColor(orange.getColor()));
	    	canvas.drawArc(mOvals, orange.getStartAngle(), orange.getSweep(), true, mBgPaints);
	    	
	    	// yellow
	    	mBgPaints.setColor(Color.parseColor(yellow.getColor())); 
	    	canvas.drawArc(mOvals, yellow.getStartAngle(), yellow.getSweep(), true, mBgPaints);
	    	
	    	// green
	    	mBgPaints.setColor(Color.GREEN);
	    	canvas.drawArc(mOvals, angle, drkGreenVal, true, mBgPaints);
	    	
    	} else 
    	{
	    	canvas.drawArc(mOvals, 270, 140, true, mBgPaints);
	    	mBgPaints.setColor(Color.YELLOW);
	    	canvas.drawArc(mOvals, 50, 40, true, mBgPaints);
	    	mBgPaints.setColor(Color.parseColor("#574200"));
	    	canvas.drawArc(mOvals, 90, 40, true, mBgPaints);
	    	mBgPaints.setColor(Color.parseColor("#0085BA"));
	    	canvas.drawArc(mOvals, 130, 50, true, mBgPaints);
	    	mBgPaints.setColor(Color.parseColor("#F59C3D"));
	    	canvas.drawArc(mOvals, 180, 90, true, mBgPaints);
    	}    	
    	canvas.drawBitmap(overlayBitmap, 0.0f, 0.0f, null); 
    }
	
	public void wedgeDetect(float x, float y)
	{
		// Handle wedge tap detection here
		System.out.println("The value of x is: " + x + " The value of y is: " + y);
		int width = this.getWidth(); 
		int height = this.getHeight(); 
		System.out.println("The supposed ctr coordinates: " + width + " " + height);
		// radius of circle is the width / 2
		//overlayBitmap.getC
	}
	public void setMode(int mode){
		drawMode = mode;	
	}
}