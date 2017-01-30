import java.util.Date;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("fg")
public final class class159 extends Buffer {
   @ObfuscatedName("o")
   class160 field2123;
   @ObfuscatedName("a")
   static final int[] field2124 = new int[]{0, 1, 3, 7, 15, 31, 63, 127, 255, 511, 1023, 2047, 4095, 8191, 16383, 32767, '\uffff', 131071, 262143, 524287, 1048575, 2097151, 4194303, 8388607, 16777215, 33554431, 67108863, 134217727, 268435455, 536870911, 1073741823, Integer.MAX_VALUE, -1};
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 365911203
   )
   int field2125;
   @ObfuscatedName("qr")
   protected static class109 field2127;

   @ObfuscatedName("hq")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "535114892"
   )
   public void method3037(int var1) {
      super.payload[++super.offset - 1] = (byte)(var1 + this.field2123.method3066());
   }

   @ObfuscatedName("hw")
   @ObfuscatedSignature(
      signature = "([IB)V",
      garbageValue = "-27"
   )
   public void method3038(int[] var1) {
      this.field2123 = new class160(var1);
   }

   @ObfuscatedName("hb")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-988562320"
   )
   public int method3040() {
      return super.payload[++super.offset - 1] - this.field2123.method3066() & 255;
   }

   @ObfuscatedName("dv")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;I)[Ljava/lang/String;",
      garbageValue = "2111621171"
   )
   static final String[] method3042(String[] var0) {
      String[] var1 = new String[5];

      for(int var2 = 0; var2 < 5; ++var2) {
         var1[var2] = var2 + ": ";
         if(var0 != null && var0[var2] != null) {
            var1[var2] = var1[var2] + var0[var2];
         }
      }

      return var1;
   }

   @ObfuscatedName("hs")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1113246729"
   )
   public void method3043() {
      super.offset = (this.field2125 + 7) / 8;
   }

   @ObfuscatedName("hu")
   @ObfuscatedSignature(
      signature = "(IB)I",
      garbageValue = "3"
   )
   public int method3044(int var1) {
      return var1 * 8 - this.field2125;
   }

   @ObfuscatedName("hl")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-837053882"
   )
   public void method3054() {
      this.field2125 = super.offset * 8;
   }

   @ObfuscatedName("bg")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1459172666"
   )
   static final void method3057(int var0) {
      int[] var1 = WidgetNode.field174.image;
      int var2 = var1.length;

      int var3;
      for(var3 = 0; var3 < var2; ++var3) {
         var1[var3] = 0;
      }

      int var4;
      int var5;
      for(var3 = 1; var3 < 103; ++var3) {
         var4 = 2048 * (103 - var3) + 24628;

         for(var5 = 1; var5 < 103; ++var5) {
            if((class10.tileSettings[var0][var5][var3] & 24) == 0) {
               Renderable.region.method1733(var1, var4, 512, var0, var5, var3);
            }

            if(var0 < 3 && (class10.tileSettings[var0 + 1][var5][var3] & 8) != 0) {
               Renderable.region.method1733(var1, var4, 512, 1 + var0, var5, var3);
            }

            var4 += 4;
         }
      }

      var3 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
      var4 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
      WidgetNode.field174.method4134();

      int var6;
      for(var5 = 1; var5 < 103; ++var5) {
         for(var6 = 1; var6 < 103; ++var6) {
            if((class10.tileSettings[var0][var6][var5] & 24) == 0) {
               class189.method3440(var0, var6, var5, var3, var4);
            }

            if(var0 < 3 && (class10.tileSettings[var0 + 1][var6][var5] & 8) != 0) {
               class189.method3440(var0 + 1, var6, var5, var3, var4);
            }
         }
      }

      Client.field343 = 0;

      for(var5 = 0; var5 < 104; ++var5) {
         for(var6 = 0; var6 < 104; ++var6) {
            int var7 = Renderable.region.method1741(WallObject.plane, var5, var6);
            if(var7 != 0) {
               var7 = var7 >> 14 & 32767;
               int var8 = class217.getObjectDefinition(var7).mapIconId;
               if(var8 >= 0) {
                  int var9 = var5;
                  int var10 = var6;
                  if(var8 != 22 && var8 != 29 && var8 != 34 && var8 != 36 && var8 != 46 && var8 != 47 && var8 != 48) {
                     int[][] var13 = Client.collisionMaps[WallObject.plane].flags;

                     for(int var14 = 0; var14 < 10; ++var14) {
                        int var15 = (int)(Math.random() * 4.0D);
                        if(var15 == 0 && var9 > 0 && var9 > var5 - 3 && (var13[var9 - 1][var10] & 19136776) == 0) {
                           --var9;
                        }

                        if(var15 == 1 && var9 < 103 && var9 < 3 + var5 && (var13[1 + var9][var10] & 19136896) == 0) {
                           ++var9;
                        }

                        if(var15 == 2 && var10 > 0 && var10 > var6 - 3 && (var13[var9][var10 - 1] & 19136770) == 0) {
                           --var10;
                        }

                        if(var15 == 3 && var10 < 103 && var10 < 3 + var6 && (var13[var9][var10 + 1] & 19136800) == 0) {
                           ++var10;
                        }
                     }
                  }

                  Client.field510[Client.field343] = class16.field171[var8];
                  Client.field508[Client.field343] = var9;
                  Client.field531[Client.field343] = var10;
                  ++Client.field343;
               }
            }
         }
      }

      class57.bufferProvider.method4062();
   }

   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "5000"
   )
   public class159(int var1) {
      super(var1);
   }

   @ObfuscatedName("ho")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "872276168"
   )
   public int method3061(int var1) {
      int var2 = this.field2125 >> 3;
      int var3 = 8 - (this.field2125 & 7);
      int var4 = 0;

      for(this.field2125 += var1; var1 > var3; var3 = 8) {
         var4 += (super.payload[var2++] & field2124[var3]) << var1 - var3;
         var1 -= var3;
      }

      if(var3 == var1) {
         var4 += super.payload[var2] & field2124[var3];
      } else {
         var4 += super.payload[var2] >> var3 - var1 & field2124[var1];
      }

      return var4;
   }

   @ObfuscatedName("ew")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "82498433"
   )
   static void method3062(String var0) {
      class47.field927 = var0;

      try {
         String var1 = class88.field1536.getParameter(class214.field3157.field3160);
         String var2 = class88.field1536.getParameter(class214.field3158.field3160);
         String var3 = var1 + "settings=" + var0 + "; version=1; path=/; domain=" + var2;
         String var5;
         if(var0.length() == 0) {
            var3 = var3 + "; Expires=Thu, 01-Jan-1970 00:00:00 GMT; Max-Age=0";
         } else {
            String var4 = var3 + "; Expires=";
            long var6 = FrameMap.method1695() + 94608000000L;
            class162.field2146.setTime(new Date(var6));
            int var8 = class162.field2146.get(7);
            int var9 = class162.field2146.get(5);
            int var10 = class162.field2146.get(2);
            int var11 = class162.field2146.get(1);
            int var12 = class162.field2146.get(11);
            int var13 = class162.field2146.get(12);
            int var14 = class162.field2146.get(13);
            var5 = class162.field2148[var8 - 1] + ", " + var9 / 10 + var9 % 10 + "-" + class162.field2145[0][var10] + "-" + var11 + " " + var12 / 10 + var12 % 10 + ":" + var13 / 10 + var13 % 10 + ":" + var14 / 10 + var14 % 10 + " GMT";
            var3 = var4 + var5 + "; Max-Age=" + 94608000L;
         }

         Client var16 = class88.field1536;
         var5 = "document.cookie=\"" + var3 + "\"";
         JSObject.getWindow(var16).eval(var5);
      } catch (Throwable var15) {
         ;
      }

   }

   @ObfuscatedName("cm")
   @ObfuscatedSignature(
      signature = "(IIB)Ljava/lang/String;",
      garbageValue = "-7"
   )
   static final String method3065(int var0, int var1) {
      int var2 = var1 - var0;
      return var2 < -9?Client.method568(16711680):(var2 < -6?Client.method568(16723968):(var2 < -3?Client.method568(16740352):(var2 < 0?Client.method568(16756736):(var2 > 9?Client.method568('\uff00'):(var2 > 6?Client.method568(4259584):(var2 > 3?Client.method568(8453888):(var2 > 0?Client.method568(12648192):Client.method568(16776960))))))));
   }
}
