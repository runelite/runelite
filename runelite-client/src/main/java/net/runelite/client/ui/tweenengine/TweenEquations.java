package net.runelite.client.ui.tweenengine;

import net.runelite.client.ui.tweenengine.equations.*;

/**
 * Collection of built-in easing equations
 *
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 */
public interface TweenEquations
{
	Linear easeNone = Linear.INOUT;
	Quad easeInQuad = Quad.IN;
	Quad easeOutQuad = Quad.OUT;
	Quad easeInOutQuad = Quad.INOUT;
	Cubic easeInCubic = Cubic.IN;
	Cubic easeOutCubic = Cubic.OUT;
	Cubic easeInOutCubic = Cubic.INOUT;
	Quart easeInQuart = Quart.IN;
	Quart easeOutQuart = Quart.OUT;
	Quart easeInOutQuart = Quart.INOUT;
	Quint easeInQuint = Quint.IN;
	Quint easeOutQuint = Quint.OUT;
	Quint easeInOutQuint = Quint.INOUT;
	Circ easeInCirc = Circ.IN;
	Circ easeOutCirc = Circ.OUT;
	Circ easeInOutCirc = Circ.INOUT;
	Sine easeInSine = Sine.IN;
	Sine easeOutSine = Sine.OUT;
	Sine easeInOutSine = Sine.INOUT;
	Expo easeInExpo = Expo.IN;
	Expo easeOutExpo = Expo.OUT;
	Expo easeInOutExpo = Expo.INOUT;
	Back easeInBack = Back.IN;
	Back easeOutBack = Back.OUT;
	Back easeInOutBack = Back.INOUT;
	Bounce easeInBounce = Bounce.IN;
	Bounce easeOutBounce = Bounce.OUT;
	Bounce easeInOutBounce = Bounce.INOUT;
	Elastic easeInElastic = Elastic.IN;
	Elastic easeOutElastic = Elastic.OUT;
	Elastic easeInOutElastic = Elastic.INOUT;
}
