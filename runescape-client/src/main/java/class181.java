import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fv")
public class class181 {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -22071457
   )
   static int field2508;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -262823873
   )
   static int field2501;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 551457143
   )
   static int field2502;
   @ObfuscatedName("z")
   static byte[][] field2503;
   @ObfuscatedName("v")
   static byte[][] field2507;
   @ObfuscatedName("m")
   static byte[][] field2505;
   @ObfuscatedName("t")
   static int[] field2504;
   @ObfuscatedName("p")
   static byte[][][] field2509;
   @ObfuscatedName("iu")
   @ObfuscatedSignature(
      signature = "Lbw;"
   )
   @Export("localPlayer")
   static Player localPlayer;

   static {
      field2508 = 0;
      field2501 = 0;
      field2502 = 0;
      field2503 = new byte[1000][];
      field2507 = new byte[250][];
      field2505 = new byte[50][];
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1205048616"
   )
   public static final void method3521(int var0, int var1) {
      class133.Viewport_mouseX = var0;
      class133.Viewport_mouseY = var1;
      class133.Viewport_containsMouse = true;
      class133.Viewport_entityCountAtMouse = 0;
      class133.Viewport_false0 = false;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IZI)[B",
      garbageValue = "-906917032"
   )
   static synchronized byte[] method3510(int var0, boolean var1) {
      byte[] var2;
      if(var0 != 100) {
         if(var0 < 100) {
            ;
         }
      } else if(field2508 > 0) {
         var2 = field2503[--field2508];
         field2503[field2508] = null;
         return var2;
      }

      if(var0 != 5000) {
         if(var0 < 5000) {
            ;
         }
      } else if(field2501 > 0) {
         var2 = field2507[--field2501];
         field2507[field2501] = null;
         return var2;
      }

      if(var0 != 30000) {
         if(var0 < 30000) {
            ;
         }
      } else if(field2502 > 0) {
         var2 = field2505[--field2502];
         field2505[field2502] = null;
         return var2;
      }

      if(field2509 != null) {
         for(int var4 = 0; var4 < class3.field23.length; ++var4) {
            if(class3.field23[var4] != var0) {
               if(var0 < class3.field23[var4]) {
                  ;
               }
            } else if(field2504[var4] > 0) {
               byte[] var3 = field2509[var4][--field2504[var4]];
               field2509[var4][field2504[var4]] = null;
               return var3;
            }
         }
      }

      return new byte[var0];
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IB)Lik;",
      garbageValue = "77"
   )
   @Export("getKitDefinition")
   public static KitDefinition getKitDefinition(int var0) {
      KitDefinition var1 = (KitDefinition)KitDefinition.identKits.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = KitDefinition.identKit_ref.getConfigData(3, var0);
         var1 = new KitDefinition();
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         KitDefinition.identKits.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("hl")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "628131469"
   )
   static final void method3523() {
      for(PendingSpawn var0 = (PendingSpawn)Client.pendingSpawns.getFront(); var0 != null; var0 = (PendingSpawn)Client.pendingSpawns.getNext()) {
         if(var0.hitpoints > 0) {
            --var0.hitpoints;
         }

         boolean var1;
         int var2;
         int var3;
         ObjectComposition var4;
         if(var0.hitpoints == 0) {
            if(var0.field1134 >= 0) {
               var2 = var0.field1134;
               var3 = var0.field1140;
               var4 = class3.getObjectDefinition(var2);
               if(var3 == 11) {
                  var3 = 10;
               }

               if(var3 >= 5 && var3 <= 8) {
                  var3 = 4;
               }

               var1 = var4.method4694(var3);
               if(!var1) {
                  continue;
               }
            }

            class61.method1085(var0.level, var0.type, var0.x, var0.y, var0.field1134, var0.field1139, var0.field1140);
            var0.unlink();
         } else {
            if(var0.delay > 0) {
               --var0.delay;
            }

            if(var0.delay == 0 && var0.x >= 1 && var0.y >= 1 && var0.x <= 102 && var0.y <= 102) {
               if(var0.id >= 0) {
                  var2 = var0.id;
                  var3 = var0.field1143;
                  var4 = class3.getObjectDefinition(var2);
                  if(var3 == 11) {
                     var3 = 10;
                  }

                  if(var3 >= 5 && var3 <= 8) {
                     var3 = 4;
                  }

                  var1 = var4.method4694(var3);
                  if(!var1) {
                     continue;
                  }
               }

               class61.method1085(var0.level, var0.type, var0.x, var0.y, var0.id, var0.orientation, var0.field1143);
               var0.delay = -1;
               if(var0.field1134 == var0.id && var0.field1134 == -1) {
                  var0.unlink();
               } else if(var0.id == var0.field1134 && var0.orientation == var0.field1139 && var0.field1143 == var0.field1140) {
                  var0.unlink();
               }
            }
         }
      }

   }
}
