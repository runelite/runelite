package net.runelite.client.ui.tweenengine;

/**
 * TweenCallbacks are used to trigger actions at some specific times. They are
 * used in both Tweens and Timelines. The moment when the callback is
 * triggered depends on its registered triggers:
 * <p/>
 * <p>
 * <b>BEGIN</b>: right after the delay (if any)<br/>
 * <b>START</b>: at each iteration beginning<br/>
 * <b>END</b>: at each iteration ending, before the repeat delay<br/>
 * <b>COMPLETE</b>: at last END event<br/>
 * <b>BACK_BEGIN</b>: at the beginning of the first backward iteration<br/>
 * <b>BACK_START</b>: at each backward iteration beginning, after the repeat delay<br/>
 * <b>BACK_END</b>: at each backward iteration ending<br/>
 * <b>BACK_COMPLETE</b>: at last BACK_END event
 * <p/>
 * <p>
 * <pre> {@code
 * forward :      BEGIN                                   COMPLETE
 * forward :      START    END      START    END      START    END
 * |--------------[XXXXXXXXXX]------[XXXXXXXXXX]------[XXXXXXXXXX]
 * backward:      bEND  bSTART      bEND  bSTART      bEND  bSTART
 * backward:      bCOMPLETE                                 bBEGIN
 * }</pre>
 *
 * @author Aurelien Ribon | http://www.aurelienribon.com/
 * @see Tween
 * @see Timeline
 */
public interface TweenCallback
{
	int BEGIN = 0x01;
	int START = 0x02;
	int END = 0x04;
	int COMPLETE = 0x08;
	int BACK_BEGIN = 0x10;
	int BACK_START = 0x20;
	int BACK_END = 0x40;
	int BACK_COMPLETE = 0x80;
	int ANY_FORWARD = 0x0F;
	int ANY_BACKWARD = 0xF0;
	int ANY = 0xFF;

	void onEvent(int type, BaseTween<?> source);
}
