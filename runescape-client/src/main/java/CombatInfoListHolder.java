import java.util.Date;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("au")
@Implements("CombatInfoListHolder")
public class CombatInfoListHolder extends Node {
   @ObfuscatedName("t")
   @Export("combatInfo1")
   CombatInfoList combatInfo1 = new CombatInfoList();
   @ObfuscatedName("i")
   @Export("combatInfo2")
   CombatInfo2 combatInfo2;
   @ObfuscatedName("or")
   @ObfuscatedGetter(
      intValue = 433551383
   )
   static int field753;

   @ObfuscatedName("b")
   public static String method767(long var0) {
      class162.field2141.setTime(new Date(var0));
      int var2 = class162.field2141.get(7);
      int var3 = class162.field2141.get(5);
      int var4 = class162.field2141.get(2);
      int var5 = class162.field2141.get(1);
      int var6 = class162.field2141.get(11);
      int var7 = class162.field2141.get(12);
      int var8 = class162.field2141.get(13);
      return class162.field2143[var2 - 1] + ", " + var3 / 10 + var3 % 10 + "-" + class162.field2140[0][var4] + "-" + var5 + " " + var6 / 10 + var6 % 10 + ":" + var7 / 10 + var7 % 10 + ":" + var8 / 10 + var8 % 10 + " GMT";
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)LCombatInfo1;",
      garbageValue = "-1919461460"
   )
   CombatInfo1 method768(int var1) {
      CombatInfo1 var2 = (CombatInfo1)this.combatInfo1.method2455();
      if(null != var2 && var2.field668 <= var1) {
         for(CombatInfo1 var3 = (CombatInfo1)this.combatInfo1.method2437(); null != var3 && var3.field668 <= var1; var3 = (CombatInfo1)this.combatInfo1.method2437()) {
            var2.unlink();
            var2 = var3;
         }

         if(this.combatInfo2.field2840 + var2.field666 + var2.field668 > var1) {
            return var2;
         } else {
            var2.unlink();
            return null;
         }
      } else {
         return null;
      }
   }

   @ObfuscatedName("di")
   @ObfuscatedSignature(
      signature = "(LWidget;B)Z",
      garbageValue = "-78"
   )
   static final boolean method769(Widget var0) {
      int var1 = var0.contentType;
      if(var1 == 205) {
         Client.field337 = 250;
         return true;
      } else {
         int var2;
         int var3;
         if(var1 >= 300 && var1 <= 313) {
            var2 = (var1 - 300) / 2;
            var3 = var1 & 1;
            Client.field562.method3235(var2, var3 == 1);
         }

         if(var1 >= 314 && var1 <= 323) {
            var2 = (var1 - 314) / 2;
            var3 = var1 & 1;
            Client.field562.method3225(var2, var3 == 1);
         }

         if(var1 == 324) {
            Client.field562.method3226(false);
         }

         if(var1 == 325) {
            Client.field562.method3226(true);
         }

         if(var1 == 326) {
            Client.field327.method3124(175);
            Client.field562.method3227(Client.field327);
            return true;
         } else {
            return false;
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "0"
   )
   boolean method773() {
      return this.combatInfo1.method2438();
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "1147118495"
   )
   void method775(int var1, int var2, int var3, int var4) {
      CombatInfo1 var5 = null;
      int var6 = 0;

      for(CombatInfo1 var7 = (CombatInfo1)this.combatInfo1.method2455(); null != var7; var7 = (CombatInfo1)this.combatInfo1.method2437()) {
         ++var6;
         if(var7.field668 == var1) {
            var7.method643(var1, var2, var3, var4);
            return;
         }

         if(var7.field668 <= var1) {
            var5 = var7;
         }
      }

      if(null == var5) {
         if(var6 < 4) {
            this.combatInfo1.method2433(new CombatInfo1(var1, var2, var3, var4));
         }

      } else {
         CombatInfoList.method2434(new CombatInfo1(var1, var2, var3, var4), var5);
         if(var6 >= 4) {
            this.combatInfo1.method2455().unlink();
         }

      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)[LModIcon;",
      garbageValue = "-754939604"
   )
   static ModIcon[] method776() {
      ModIcon[] var0 = new ModIcon[class225.field3226];

      for(int var1 = 0; var1 < class225.field3226; ++var1) {
         ModIcon var2 = var0[var1] = new ModIcon();
         var2.width = class225.field3228;
         var2.originalHeight = class225.field3227;
         var2.offsetX = class225.field3229[var1];
         var2.offsetY = class155.field2105[var1];
         var2.originalWidth = class172.field2351[var1];
         var2.height = class225.field3230[var1];
         var2.palette = class225.field3231;
         var2.pixels = class225.field3232[var1];
      }

      class0.method13();
      return var0;
   }

   CombatInfoListHolder(CombatInfo2 var1) {
      this.combatInfo2 = var1;
   }

   @ObfuscatedName("dl")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "879012725"
   )
   static final void method777(int var0) {
      Friend.method187();

      for(class31 var4 = (class31)class31.field700.method2472(); null != var4; var4 = (class31)class31.field700.method2479()) {
         if(var4.field714 != null) {
            var4.method704();
         }
      }

      int var1 = class110.method2137(var0).field2767;
      if(var1 != 0) {
         int var2 = class165.widgetSettings[var0];
         if(var1 == 1) {
            if(var2 == 1) {
               class84.method1700(0.9D);
               ((TextureProvider)class84.field1415).method1511(0.9D);
            }

            if(var2 == 2) {
               class84.method1700(0.8D);
               ((TextureProvider)class84.field1415).method1511(0.8D);
            }

            if(var2 == 3) {
               class84.method1700(0.7D);
               ((TextureProvider)class84.field1415).method1511(0.7D);
            }

            if(var2 == 4) {
               class84.method1700(0.6D);
               ((TextureProvider)class84.field1415).method1511(0.6D);
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

            if(var3 != Client.field522) {
               if(Client.field522 == 0 && Client.field523 != -1) {
                  GameEngine.method2168(XItemContainer.field122, Client.field523, 0, var3, false);
                  Client.field401 = false;
               } else if(var3 == 0) {
                  class39.field800.method2668();
                  class138.field1915 = 1;
                  class138.field1918 = null;
                  Client.field401 = false;
               } else if(class138.field1915 != 0) {
                  FaceNormal.field1561 = var3;
               } else {
                  class39.field800.method2558(var3);
               }

               Client.field522 = var3;
            }
         }

         if(var1 == 4) {
            if(var2 == 0) {
               Client.field525 = 127;
            }

            if(var2 == 1) {
               Client.field525 = 96;
            }

            if(var2 == 2) {
               Client.field525 = 64;
            }

            if(var2 == 3) {
               Client.field525 = 32;
            }

            if(var2 == 4) {
               Client.field525 = 0;
            }
         }

         if(var1 == 5) {
            Client.field422 = var2;
         }

         if(var1 == 6) {
            Client.field447 = var2;
         }

         if(var1 == 9) {
            Client.field448 = var2;
         }

         if(var1 == 10) {
            if(var2 == 0) {
               Client.field526 = 127;
            }

            if(var2 == 1) {
               Client.field526 = 96;
            }

            if(var2 == 2) {
               Client.field526 = 64;
            }

            if(var2 == 3) {
               Client.field526 = 32;
            }

            if(var2 == 4) {
               Client.field526 = 0;
            }
         }

         if(var1 == 17) {
            Client.field453 = var2 & '\uffff';
         }

         if(var1 == 18) {
            Client.field359 = (class40)class37.method801(class8.method115(), var2);
            if(Client.field359 == null) {
               Client.field359 = class40.field807;
            }
         }

         if(var1 == 19) {
            if(var2 == -1) {
               Client.field414 = -1;
            } else {
               Client.field414 = var2 & 2047;
            }
         }

         if(var1 == 22) {
            Client.field416 = (class40)class37.method801(class8.method115(), var2);
            if(null == Client.field416) {
               Client.field416 = class40.field807;
            }
         }

      }
   }
}
