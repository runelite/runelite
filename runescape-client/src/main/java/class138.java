import java.awt.Container;
import java.awt.Insets;
import java.util.Calendar;
import java.util.TimeZone;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("el")
public class class138 {
   @ObfuscatedName("c")
   static final String[] field2002 = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
   @ObfuscatedName("d")
   static final String[][] field2003 = new String[][]{{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}, {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"}};
   @ObfuscatedName("n")
   static Calendar field2004;
   @ObfuscatedName("r")
   static int[] field2005;

   @ObfuscatedName("as")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1515312374"
   )
   static void method2672() {
      Client var0 = Client.field279;
      synchronized(Client.field279) {
         Container var1 = Client.field279.method2130();
         if(var1 != null) {
            GroundObject.field1285 = Math.max(var1.getSize().width, class94.field1563);
            class20.field221 = Math.max(var1.getSize().height, Ignore.field210);
            if(var1 == class3.field26) {
               Insets var2 = class3.field26.getInsets();
               GroundObject.field1285 -= var2.left + var2.right;
               class20.field221 -= var2.top + var2.bottom;
            }

            if(GroundObject.field1285 <= 0) {
               GroundObject.field1285 = 1;
            }

            if(class20.field221 <= 0) {
               class20.field221 = 1;
            }

            int var5 = Client.isResized?2:1;
            if(var5 == 1) {
               class187.field2760 = Client.field293;
               IndexDataBase.field2726 = Client.field322 * 503;
            } else {
               class187.field2760 = Math.min(GroundObject.field1285, 7680);
               IndexDataBase.field2726 = Math.min(class20.field221, 2160);
            }

            GameEngine.field1766 = (GroundObject.field1285 - class187.field2760) / 2;
            GameEngine.field1783 = 0;
            class65.canvas.setSize(class187.field2760, IndexDataBase.field2726);
            class88.bufferProvider = NPCComposition.method3805(class187.field2760, IndexDataBase.field2726, class65.canvas);
            if(class3.field26 == var1) {
               Insets var3 = class3.field26.getInsets();
               class65.canvas.setLocation(var3.left + GameEngine.field1766, GameEngine.field1783 + var3.top);
            } else {
               class65.canvas.setLocation(GameEngine.field1766, GameEngine.field1783);
            }

            class198.method3598();
            if(Client.widgetRoot != -1) {
               class15.method188(true);
            }

            RSSocket.method2095();
         }
      }
   }

   static {
      Calendar.getInstance(TimeZone.getTimeZone("Europe/London"));
      field2004 = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
   }

   class138() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-117"
   )
   static final void method2675() {
      Region.field1469 = false;
      Client.field285 = false;
   }
}
