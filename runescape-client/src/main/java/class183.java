import java.awt.event.ActionEvent;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gi")
public class class183 implements Runnable {
   @ObfuscatedName("i")
   public static Deque field2745 = new Deque();
   @ObfuscatedName("f")
   public static Deque field2746 = new Deque();
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -657295343
   )
   public static int field2747 = 0;
   @ObfuscatedName("h")
   public static Object field2748 = new Object();

   public void run() {
      try {
         while(true) {
            Deque var2 = field2746;
            class180 var1;
            synchronized(field2746) {
               var1 = (class180)field2746.method2464();
            }

            Object var14;
            if(null != var1) {
               if(var1.field2719 == 0) {
                  var1.field2716.method2303((int)var1.hash, var1.field2715, var1.field2715.length);
                  var2 = field2746;
                  synchronized(field2746) {
                     var1.unlink();
                  }
               } else if(var1.field2719 == 1) {
                  var1.field2715 = var1.field2716.method2310((int)var1.hash);
                  var2 = field2746;
                  synchronized(field2746) {
                     field2745.method2459(var1);
                  }
               }

               var14 = field2748;
               synchronized(field2748) {
                  if(field2747 <= 1) {
                     field2747 = 0;
                     field2748.notifyAll();
                     return;
                  }

                  field2747 = 600;
               }
            } else {
               class115.method2300(100L);
               var14 = field2748;
               synchronized(field2748) {
                  if(field2747 <= 1) {
                     field2747 = 0;
                     field2748.notifyAll();
                     return;
                  }

                  --field2747;
               }
            }
         }
      } catch (Exception var13) {
         GameObject.method1958((String)null, var13);
      }
   }

   @ObfuscatedName("db")
   @ObfuscatedSignature(
      signature = "(IIIILSpritePixels;Lclass164;I)V",
      garbageValue = "224888880"
   )
   static final void method3409(int var0, int var1, int var2, int var3, SpritePixels var4, class164 var5) {
      if(null != var4) {
         int var6 = Client.mapAngle + Client.mapScale & 2047;
         int var7 = var3 * var3 + var2 * var2;
         if(var7 <= 6400) {
            int var8 = class84.field1475[var6];
            int var9 = class84.field1469[var6];
            var8 = var8 * 256 / (Client.mapScaleDelta + 256);
            var9 = 256 * var9 / (256 + Client.mapScaleDelta);
            int var10 = var2 * var9 + var8 * var3 >> 16;
            int var11 = var3 * var9 - var8 * var2 >> 16;
            if(var7 > 2500) {
               var4.method4160(var5.field2174 / 2 + var10 - var4.maxWidth / 2, var5.field2172 / 2 - var11 - var4.maxHeight / 2, var0, var1, var5.field2174, var5.field2172, var5.field2173, var5.field2171);
            } else {
               var4.method4143(var5.field2174 / 2 + var0 + var10 - var4.maxWidth / 2, var5.field2172 / 2 + var1 - var11 - var4.maxHeight / 2);
            }

         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(CII)C",
      garbageValue = "457127855"
   )
   static char method3411(char var0, int var1) {
      if(var0 >= 192 && var0 <= 255) {
         if(var0 >= 192 && var0 <= 198) {
            return 'A';
         }

         if(var0 == 199) {
            return 'C';
         }

         if(var0 >= 200 && var0 <= 203) {
            return 'E';
         }

         if(var0 >= 204 && var0 <= 207) {
            return 'I';
         }

         if(var0 >= 210 && var0 <= 214) {
            return 'O';
         }

         if(var0 >= 217 && var0 <= 220) {
            return 'U';
         }

         if(var0 == 221) {
            return 'Y';
         }

         if(var0 == 223) {
            return 's';
         }

         if(var0 >= 224 && var0 <= 230) {
            return 'a';
         }

         if(var0 == 231) {
            return 'c';
         }

         if(var0 >= 232 && var0 <= 235) {
            return 'e';
         }

         if(var0 >= 236 && var0 <= 239) {
            return 'i';
         }

         if(var0 >= 242 && var0 <= 246) {
            return 'o';
         }

         if(var0 >= 249 && var0 <= 252) {
            return 'u';
         }

         if(var0 == 253 || var0 == 255) {
            return 'y';
         }
      }

      if(var0 == 338) {
         return 'O';
      } else if(var0 == 339) {
         return 'o';
      } else if(var0 == 376) {
         return 'Y';
      } else {
         return var0;
      }
   }

   @ObfuscatedName("dr")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1808355285"
   )
   static final void method3413() {
      Client.secretCipherBuffer1.putOpcode(48);

      for(WidgetNode var0 = (WidgetNode)Client.componentTable.method2420(); var0 != null; var0 = (WidgetNode)Client.componentTable.method2422()) {
         if(var0.field187 == 0 || var0.field187 == 3) {
            Item.method828(var0, true);
         }
      }

      if(null != Client.field467) {
         class22.method197(Client.field467);
         Client.field467 = null;
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lclass103;Ljava/lang/Object;I)V",
      garbageValue = "756595681"
   )
   public static void method3415(class103 var0, Object var1) {
      if(null != var0.field1696) {
         for(int var2 = 0; var2 < 50 && var0.field1696.peekEvent() != null; ++var2) {
            class115.method2300(1L);
         }

         if(null != var1) {
            var0.field1696.postEvent(new ActionEvent(var1, 1001, "dummy"));
         }

      }
   }
}
