import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fx")
public class class173 implements Runnable {
   @ObfuscatedName("r")
   public static Object field2772 = new Object();
   @ObfuscatedName("d")
   public static Deque field2773 = new Deque();
   @ObfuscatedName("a")
   public static Deque field2774 = new Deque();
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1531390651
   )
   public static int field2777 = 0;

   public void run() {
      try {
         while(true) {
            Deque var2 = field2774;
            class172 var1;
            synchronized(field2774) {
               var1 = (class172)field2774.method3854();
            }

            Object var14;
            if(null != var1) {
               if(var1.field2767 == 0) {
                  var1.field2763.method2901((int)var1.hash, var1.field2762, var1.field2762.length);
                  var2 = field2774;
                  synchronized(field2774) {
                     var1.unlink();
                  }
               } else if(var1.field2767 == 1) {
                  var1.field2762 = var1.field2763.method2903((int)var1.hash);
                  var2 = field2774;
                  synchronized(field2774) {
                     field2773.method3849(var1);
                  }
               }

               var14 = field2772;
               synchronized(field2772) {
                  if(field2777 <= 1) {
                     field2777 = 0;
                     field2772.notifyAll();
                     return;
                  }

                  field2777 = 600;
               }
            } else {
               Item.method681(100L);
               var14 = field2772;
               synchronized(field2772) {
                  if(field2777 <= 1) {
                     field2777 = 0;
                     field2772.notifyAll();
                     return;
                  }

                  --field2777;
               }
            }
         }
      } catch (Exception var13) {
         class128.method2843((String)null, var13);
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ZZI)I",
      garbageValue = "1492722611"
   )
   public static int method3418(boolean var0, boolean var1) {
      byte var2 = 0;
      int var3 = var2 + class174.field2785 + class174.field2783;
      return var3;
   }

   @ObfuscatedName("ai")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1063378636"
   )
   static final int method3419() {
      if(class116.field2039.field131) {
         return Item.plane;
      } else {
         int var0 = 3;
         if(class18.cameraPitch < 310) {
            int var1 = class165.cameraX >> 7;
            int var2 = class9.cameraY >> 7;
            int var3 = WidgetNode.localPlayer.x >> 7;
            int var4 = WidgetNode.localPlayer.y >> 7;
            if(var1 < 0 || var2 < 0 || var1 >= 104 || var2 >= 104) {
               return Item.plane;
            }

            if((class5.tileSettings[Item.plane][var1][var2] & 4) != 0) {
               var0 = Item.plane;
            }

            int var5;
            if(var3 > var1) {
               var5 = var3 - var1;
            } else {
               var5 = var1 - var3;
            }

            int var6;
            if(var4 > var2) {
               var6 = var4 - var2;
            } else {
               var6 = var2 - var4;
            }

            int var7;
            int var8;
            if(var5 > var6) {
               var7 = var6 * 65536 / var5;
               var8 = '耀';

               while(var1 != var3) {
                  if(var1 < var3) {
                     ++var1;
                  } else if(var1 > var3) {
                     --var1;
                  }

                  if((class5.tileSettings[Item.plane][var1][var2] & 4) != 0) {
                     var0 = Item.plane;
                  }

                  var8 += var7;
                  if(var8 >= 65536) {
                     var8 -= 65536;
                     if(var2 < var4) {
                        ++var2;
                     } else if(var2 > var4) {
                        --var2;
                     }

                     if((class5.tileSettings[Item.plane][var1][var2] & 4) != 0) {
                        var0 = Item.plane;
                     }
                  }
               }
            } else {
               var7 = var5 * 65536 / var6;
               var8 = '耀';

               while(var4 != var2) {
                  if(var2 < var4) {
                     ++var2;
                  } else if(var2 > var4) {
                     --var2;
                  }

                  if((class5.tileSettings[Item.plane][var1][var2] & 4) != 0) {
                     var0 = Item.plane;
                  }

                  var8 += var7;
                  if(var8 >= 65536) {
                     var8 -= 65536;
                     if(var1 < var3) {
                        ++var1;
                     } else if(var1 > var3) {
                        --var1;
                     }

                     if((class5.tileSettings[Item.plane][var1][var2] & 4) != 0) {
                        var0 = Item.plane;
                     }
                  }
               }
            }
         }

         if(WidgetNode.localPlayer.x >= 0 && WidgetNode.localPlayer.y >= 0 && WidgetNode.localPlayer.x < 13312 && WidgetNode.localPlayer.y < 13312) {
            if((class5.tileSettings[Item.plane][WidgetNode.localPlayer.x >> 7][WidgetNode.localPlayer.y >> 7] & 4) != 0) {
               var0 = Item.plane;
            }

            return var0;
         } else {
            return Item.plane;
         }
      }
   }
}
