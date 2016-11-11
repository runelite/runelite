import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("t")
public final class class24 extends Node {
   @ObfuscatedName("s")
   int[] field624;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -640702969
   )
   int field625;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1643228807
   )
   int field626;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -492707421
   )
   int field627;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -2132744107
   )
   int field628;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1644258581
   )
   int field629;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1361233711
   )
   int field630;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -450279719
   )
   int field631;
   @ObfuscatedName("m")
   class67 field632;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 8253297
   )
   int field633;
   @ObfuscatedName("i")
   static Deque field634 = new Deque();
   @ObfuscatedName("v")
   class67 field635;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1605074531
   )
   int field636;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -202585825
   )
   int field637;
   @ObfuscatedName("r")
   ObjectComposition field638;
   @ObfuscatedName("es")
   static SpritePixels[] field639;
   @ObfuscatedName("io")
   @ObfuscatedGetter(
      intValue = -104463721
   )
   static int field641;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "89"
   )
   void method566() {
      int var1 = this.field637;
      ObjectComposition var2 = this.field638.getImpostor();
      if(var2 != null) {
         this.field637 = var2.field988;
         this.field629 = var2.field952 * 128;
         this.field633 = var2.field990;
         this.field630 = var2.field991;
         this.field624 = var2.field943;
      } else {
         this.field637 = -1;
         this.field629 = 0;
         this.field633 = 0;
         this.field630 = 0;
         this.field624 = null;
      }

      if(var1 != this.field637 && null != this.field632) {
         class0.field11.method1178(this.field632);
         this.field632 = null;
      }

   }

   @ObfuscatedName("co")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1134397973"
   )
   static final void method567(int var0) {
      if(class14.method172(var0)) {
         Widget[] var1 = Widget.widgets[var0];

         for(int var2 = 0; var2 < var1.length; ++var2) {
            Widget var3 = var1[var2];
            if(var3 != null) {
               var3.field2934 = 0;
               var3.field2925 = 0;
            }
         }

      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lclass125;IB)V",
      garbageValue = "-13"
   )
   static final void method576(class125 var0, int var1) {
      int var2 = var0.offset;
      class34.field775 = 0;
      int var3 = 0;
      var0.method2786();

      int var4;
      int var5;
      int var6;
      for(var4 = 0; var4 < class34.field779; ++var4) {
         var5 = class34.field786[var4];
         if((class34.field785[var5] & 1) == 0) {
            if(var3 > 0) {
               --var3;
               class34.field785[var5] = (byte)(class34.field785[var5] | 2);
            } else {
               var6 = var0.method2787(1);
               if(var6 == 0) {
                  var3 = class26.method581(var0);
                  class34.field785[var5] = (byte)(class34.field785[var5] | 2);
               } else {
                  NPC.method747(var0, var5);
               }
            }
         }
      }

      var0.method2790();
      if(var3 != 0) {
         throw new RuntimeException();
      } else {
         var0.method2786();

         for(var4 = 0; var4 < class34.field779; ++var4) {
            var5 = class34.field786[var4];
            if((class34.field785[var5] & 1) != 0) {
               if(var3 > 0) {
                  --var3;
                  class34.field785[var5] = (byte)(class34.field785[var5] | 2);
               } else {
                  var6 = var0.method2787(1);
                  if(var6 == 0) {
                     var3 = class26.method581(var0);
                     class34.field785[var5] = (byte)(class34.field785[var5] | 2);
                  } else {
                     NPC.method747(var0, var5);
                  }
               }
            }
         }

         var0.method2790();
         if(var3 != 0) {
            throw new RuntimeException();
         } else {
            var0.method2786();

            for(var4 = 0; var4 < class34.field776; ++var4) {
               var5 = class34.field782[var4];
               if((class34.field785[var5] & 1) != 0) {
                  if(var3 > 0) {
                     --var3;
                     class34.field785[var5] = (byte)(class34.field785[var5] | 2);
                  } else {
                     var6 = var0.method2787(1);
                     if(var6 == 0) {
                        var3 = class26.method581(var0);
                        class34.field785[var5] = (byte)(class34.field785[var5] | 2);
                     } else if(ChatMessages.method233(var0, var5)) {
                        class34.field785[var5] = (byte)(class34.field785[var5] | 2);
                     }
                  }
               }
            }

            var0.method2790();
            if(var3 != 0) {
               throw new RuntimeException();
            } else {
               var0.method2786();

               for(var4 = 0; var4 < class34.field776; ++var4) {
                  var5 = class34.field782[var4];
                  if((class34.field785[var5] & 1) == 0) {
                     if(var3 > 0) {
                        --var3;
                        class34.field785[var5] = (byte)(class34.field785[var5] | 2);
                     } else {
                        var6 = var0.method2787(1);
                        if(var6 == 0) {
                           var3 = class26.method581(var0);
                           class34.field785[var5] = (byte)(class34.field785[var5] | 2);
                        } else if(ChatMessages.method233(var0, var5)) {
                           class34.field785[var5] = (byte)(class34.field785[var5] | 2);
                        }
                     }
                  }
               }

               var0.method2790();
               if(var3 != 0) {
                  throw new RuntimeException();
               } else {
                  class34.field779 = 0;
                  class34.field776 = 0;

                  for(var4 = 1; var4 < 2048; ++var4) {
                     class34.field785[var4] = (byte)(class34.field785[var4] >> 1);
                     Player var7 = Client.cachedPlayers[var4];
                     if(null != var7) {
                        class34.field786[++class34.field779 - 1] = var4;
                     } else {
                        class34.field782[++class34.field776 - 1] = var4;
                     }
                  }

                  Item.method657(var0);
                  if(var0.offset - var2 != var1) {
                     throw new RuntimeException(var0.offset - var2 + " " + var1);
                  }
               }
            }
         }
      }
   }
}
