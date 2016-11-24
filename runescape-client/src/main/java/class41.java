import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ad")
public class class41 {
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -939227427
   )
   static int field816;
   @ObfuscatedName("o")
   static int[] field817;
   @ObfuscatedName("m")
   static ModIcon field818;
   @ObfuscatedName("h")
   static ModIcon field819;
   @ObfuscatedName("w")
   static ModIcon[] field820;
   @ObfuscatedName("r")
   static SpritePixels field821;
   @ObfuscatedName("c")
   static SpritePixels field822;
   @ObfuscatedName("p")
   static ModIcon field823;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 609956309
   )
   @Export("loginWindowX")
   static int loginWindowX;
   @ObfuscatedName("ae")
   static String field826;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1205729457
   )
   static int field827;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 824775577
   )
   static int field828;
   @ObfuscatedName("af")
   @Export("loginMessage1")
   static String loginMessage1;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -335457015
   )
   @Export("loginIndex")
   static int loginIndex;
   @ObfuscatedName("n")
   static boolean field831;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 621062303
   )
   static int field832;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -1319086209
   )
   static int field833;
   @ObfuscatedName("ax")
   static String field834;
   @ObfuscatedName("am")
   static String field836;
   @ObfuscatedName("ap")
   @Export("loginMessage2")
   static String loginMessage2;
   @ObfuscatedName("az")
   @Export("loginMessage3")
   static String loginMessage3;
   @ObfuscatedName("ab")
   @Export("username")
   static String username;
   @ObfuscatedName("bv")
   static ModIcon field841;
   @ObfuscatedName("ad")
   static class97 field842;
   @ObfuscatedName("aa")
   static boolean field843;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 1106811795
   )
   @Export("loginIndex2")
   static int loginIndex2;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 1646608619
   )
   static int field847;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1204129173
   )
   static int field848 = 0;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = -1923670799
   )
   static int field849;
   @ObfuscatedName("ar")
   @Export("worldSelectShown")
   static boolean worldSelectShown;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -628278307
   )
   static int field852;

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "2"
   )
   public static void method786() {
      NPCComposition.field2994.reset();
      NPCComposition.npcModelCache.reset();
   }

   static {
      loginWindowX = field848 + 202;
      field817 = new int[256];
      field827 = 0;
      field828 = 0;
      field847 = 0;
      field816 = 0;
      field852 = 0;
      field832 = 0;
      field833 = 10;
      field826 = "";
      loginIndex = 0;
      field836 = "";
      loginMessage1 = "";
      loginMessage2 = "";
      loginMessage3 = "";
      username = "";
      field834 = "";
      field842 = class97.field1625;
      field843 = true;
      loginIndex2 = 0;
      worldSelectShown = false;
      field849 = -1;
   }

   @ObfuscatedName("ds")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-265723330"
   )
   static final void method801(int var0) {
      class182.method3405();
      class148.method2829();
      int var1 = class179.method3314(var0).field2772;
      if(var1 != 0) {
         int var2 = class146.widgetSettings[var0];
         if(var1 == 1) {
            if(var2 == 1) {
               class84.method1685(0.9D);
               ((TextureProvider)class84.field1441).method1463(0.9D);
            }

            if(var2 == 2) {
               class84.method1685(0.8D);
               ((TextureProvider)class84.field1441).method1463(0.8D);
            }

            if(var2 == 3) {
               class84.method1685(0.7D);
               ((TextureProvider)class84.field1441).method1463(0.7D);
            }

            if(var2 == 4) {
               class84.method1685(0.6D);
               ((TextureProvider)class84.field1441).method1463(0.6D);
            }

            FaceNormal.method1923();
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

            if(Client.field522 != var3) {
               if(Client.field522 == 0 && Client.field318 != -1) {
                  class119.method2349(class34.field746, Client.field318, 0, var3, false);
                  Client.field524 = false;
               } else if(var3 == 0) {
                  class13.method186();
                  Client.field524 = false;
               } else {
                  class38.method769(var3);
               }

               Client.field522 = var3;
            }
         }

         if(var1 == 4) {
            if(var2 == 0) {
               Client.field478 = 127;
            }

            if(var2 == 1) {
               Client.field478 = 96;
            }

            if(var2 == 2) {
               Client.field478 = 64;
            }

            if(var2 == 3) {
               Client.field478 = 32;
            }

            if(var2 == 4) {
               Client.field478 = 0;
            }
         }

         if(var1 == 5) {
            Client.field437 = var2;
         }

         if(var1 == 6) {
            Client.field373 = var2;
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
            Client.field459 = var2 & '\uffff';
         }

         if(var1 == 18) {
            Client.field310 = (class40)class101.method1985(class162.method3196(), var2);
            if(Client.field310 == null) {
               Client.field310 = class40.field814;
            }
         }

         if(var1 == 19) {
            if(var2 == -1) {
               Client.field525 = -1;
            } else {
               Client.field525 = var2 & 2047;
            }
         }

         if(var1 == 22) {
            Client.field487 = (class40)class101.method1985(class162.method3196(), var2);
            if(null == Client.field487) {
               Client.field487 = class40.field814;
            }
         }

      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IB)LKitDefinition;",
      garbageValue = "-18"
   )
   @Export("getKitDefinition")
   public static KitDefinition getKitDefinition(int var0) {
      KitDefinition var1 = (KitDefinition)KitDefinition.field2821.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = KitDefinition.field2829.method3329(3, var0);
         var1 = new KitDefinition();
         if(null != var2) {
            var1.method3541(new Buffer(var2));
         }

         KitDefinition.field2821.put(var1, (long)var0);
         return var1;
      }
   }
}
