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
            Deque var1 = field2746;
            Deque var2 = field2746;
            Deque var4 = field2746;
            class180 var3;
            synchronized(field2746) {
               var3 = (class180)field2746.method2464();
            }

            Object var18;
            Object var5;
            if(var3 != null) {
               Deque var19;
               Deque var7;
               if(var3.field2719 == 0) {
                  var3.field2716.method2303((int)var3.hash, var3.field2715, var3.field2715.length);
                  var1 = field2746;
                  var19 = field2746;
                  var7 = field2746;
                  synchronized(field2746) {
                     var3.unlink();
                  }
               } else if(var3.field2719 == 1) {
                  var3.field2715 = var3.field2716.method2310((int)var3.hash);
                  var1 = field2746;
                  var19 = field2746;
                  var7 = field2746;
                  synchronized(field2746) {
                     field2745.method2459(var3);
                  }
               }

               var5 = field2748;
               var18 = field2748;
               Object var20 = field2748;
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
               var5 = field2748;
               var18 = field2748;
               Object var6 = field2748;
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
      } catch (Exception var17) {
         GameObject.method1958((String)null, var17);
      }
   }

   @ObfuscatedName("db")
   @ObfuscatedSignature(
      signature = "(IIIILSpritePixels;Lclass164;I)V",
      garbageValue = "224888880"
   )
   static final void method3409(int var0, int var1, int var2, int var3, SpritePixels var4, class164 var5) {
      if(var4 != null) {
         int var6 = Client.mapAngle + Client.mapScale & 2047;
         int var7 = var3 * var3 + var2 * var2;
         if(var7 <= 6400) {
            int var8 = class84.field1475[var6];
            int var9 = class84.field1469[var6];
            var8 = var8 * 256 / (Client.mapScaleDelta + 256);
            var9 = var9 * 256 / (Client.mapScaleDelta + 256);
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

      if(Client.field467 != null) {
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
      if(var0.field1696 != null) {
         for(int var2 = 0; var2 < 50 && var0.field1696.peekEvent() != null; ++var2) {
            class115.method2300(1L);
         }

         if(var1 != null) {
            var0.field1696.postEvent(new ActionEvent(var1, 1001, "dummy"));
         }
      }

   }
}
