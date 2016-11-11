import java.awt.Canvas;
import java.awt.Component;
import java.awt.Graphics;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.mapping.Replace;

@ObfuscatedName("ee")
@Implements("RSCanvas")
@Replace("net.runelite.inject.RSCanvas")
public final class RSCanvas extends Canvas {
   @ObfuscatedName("h")
   public static class170 field2193;
   @ObfuscatedName("i")
   Component field2196;
   @ObfuscatedName("ix")
   @ObfuscatedGetter(
      intValue = -2139681175
   )
   static int field2197;

   public final void update(Graphics var1) {
      this.field2196.update(var1);
   }

   public final void paint(Graphics var1) {
      this.field2196.paint(var1);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "([BIII)Ljava/lang/String;",
      garbageValue = "-1547856965"
   )
   public static String method2975(byte[] var0, int var1, int var2) {
      char[] var3 = new char[var2];
      int var4 = 0;

      for(int var5 = 0; var5 < var2; ++var5) {
         int var6 = var0[var5 + var1] & 255;
         if(var6 != 0) {
            if(var6 >= 128 && var6 < 160) {
               char var7 = class168.field2709[var6 - 128];
               if(var7 == 0) {
                  var7 = 63;
               }

               var6 = var7;
            }

            var3[var4++] = (char)var6;
         }
      }

      return new String(var3, 0, var4);
   }

   @ObfuscatedName("dd")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "799519847"
   )
   static final void method2982(int var0) {
      class48.method996();
      class171.method3395();
      int var1 = class48.method982(var0).field1218;
      if(var1 != 0) {
         int var2 = class179.widgetSettings[var0];
         if(var1 == 1) {
            if(var2 == 1) {
               class94.method2180(0.9D);
               ((TextureProvider)class94.field1638).method2231(0.9D);
            }

            if(var2 == 2) {
               class94.method2180(0.8D);
               ((TextureProvider)class94.field1638).method2231(0.8D);
            }

            if(var2 == 3) {
               class94.method2180(0.7D);
               ((TextureProvider)class94.field1638).method2231(0.7D);
            }

            if(var2 == 4) {
               class94.method2180(0.6D);
               ((TextureProvider)class94.field1638).method2231(0.6D);
            }

            ItemComposition.itemSpriteCache.reset();
         }

         if(var1 == 3) {
            short var3 = 0;
            if(var2 == 0) {
               var3 = 255;
            }

            if(var2 == 1) {
               var3 = 192;
            }

            if(var2 == 2) {
               var3 = 128;
            }

            if(var2 == 3) {
               var3 = 64;
            }

            if(var2 == 4) {
               var3 = 0;
            }

            if(var3 != Client.field513) {
               if(Client.field513 == 0 && Client.field538 != -1) {
                  GroundObject.method2209(Client.field476, Client.field538, 0, var3, false);
                  Client.field539 = false;
               } else if(var3 == 0) {
                  Item.method659();
                  Client.field539 = false;
               } else if(class186.field3010 != 0) {
                  class186.field3016 = var3;
               } else {
                  class186.field3013.method3625(var3);
               }

               Client.field513 = var3;
            }
         }

         if(var1 == 4) {
            if(var2 == 0) {
               Client.field547 = 127;
            }

            if(var2 == 1) {
               Client.field547 = 96;
            }

            if(var2 == 2) {
               Client.field547 = 64;
            }

            if(var2 == 3) {
               Client.field547 = 32;
            }

            if(var2 == 4) {
               Client.field547 = 0;
            }
         }

         if(var1 == 5) {
            Client.field440 = var2;
         }

         if(var1 == 6) {
            Client.field462 = var2;
         }

         if(var1 == 9) {
            Client.field463 = var2;
         }

         if(var1 == 10) {
            if(var2 == 0) {
               Client.field408 = 127;
            }

            if(var2 == 1) {
               Client.field408 = 96;
            }

            if(var2 == 2) {
               Client.field408 = 64;
            }

            if(var2 == 3) {
               Client.field408 = 32;
            }

            if(var2 == 4) {
               Client.field408 = 0;
            }
         }

         if(var1 == 17) {
            Client.field566 = var2 & '\uffff';
         }

         if(var1 == 18) {
            Client.field326 = (class21)class140.method2957(class13.method161(), var2);
            if(Client.field326 == null) {
               Client.field326 = class21.field606;
            }
         }

         if(var1 == 19) {
            if(var2 == -1) {
               Client.field432 = -1;
            } else {
               Client.field432 = var2 & 2047;
            }
         }

         if(var1 == 22) {
            Client.field327 = (class21)class140.method2957(class13.method161(), var2);
            if(Client.field327 == null) {
               Client.field327 = class21.field606;
            }
         }

      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "([BI)Ljava/lang/String;",
      garbageValue = "1832027863"
   )
   public static String method2983(byte[] var0) {
      return Player.method47(var0, 0, var0.length);
   }

   RSCanvas(Component var1) {
      this.field2196 = var1;
   }
}
