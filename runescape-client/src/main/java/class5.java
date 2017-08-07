import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("k")
final class class5 implements class0 {
   @ObfuscatedName("aj")
   @Export("clientInstance")
   @ObfuscatedSignature(
      signature = "Lclient;"
   )
   static Client clientInstance;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -483880429
   )
   static int field32;
   @ObfuscatedName("fu")
   @Export("landRegionFielIds")
   static int[] landRegionFielIds;
   @ObfuscatedName("nq")
   @ObfuscatedGetter(
      intValue = 1453850609
   )
   @Export("clanChatCount")
   static int clanChatCount;

   @ObfuscatedName("hq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1563843165"
   )
   static void method12() {
      Client.menuOptionCount = 0;
      Client.isMenuOpen = false;
      Client.menuOptions[0] = "Cancel";
      Client.menuTargets[0] = "";
      Client.menuTypes[0] = 1006;
      Client.field1048[0] = false;
      Client.menuOptionCount = 1;
   }

   @ObfuscatedName("ia")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "106"
   )
   static final void method10(int var0) {
      class3.method4();
      class284.method5058();
      int var1 = class36.method497(var0).configType;
      if(var1 != 0) {
         int var2 = class212.widgetSettings[var0];
         if(var1 == 1) {
            if(var2 == 1) {
               Graphics3D.setBrightness(0.9D);
               ((TextureProvider)Graphics3D.textureLoader).brightness(0.9D);
            }

            if(var2 == 2) {
               Graphics3D.setBrightness(0.8D);
               ((TextureProvider)Graphics3D.textureLoader).brightness(0.8D);
            }

            if(var2 == 3) {
               Graphics3D.setBrightness(0.7D);
               ((TextureProvider)Graphics3D.textureLoader).brightness(0.7D);
            }

            if(var2 == 4) {
               Graphics3D.setBrightness(0.6D);
               ((TextureProvider)Graphics3D.textureLoader).brightness(0.6D);
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

            if(var3 != Client.field1060) {
               if(Client.field1060 == 0 && Client.field1140 != -1) {
                  WorldMapType1.method276(class244.indexTrack1, Client.field1140, 0, var3, false);
                  Client.field1141 = false;
               } else if(var3 == 0) {
                  class204.field2486.method3738();
                  class204.field2487 = 1;
                  class204.field2488 = null;
                  Client.field1141 = false;
               } else {
                  GraphicsObject.method1694(var3);
               }

               Client.field1060 = var3;
            }
         }

         if(var1 == 4) {
            if(var2 == 0) {
               Client.field1109 = 127;
            }

            if(var2 == 1) {
               Client.field1109 = 96;
            }

            if(var2 == 2) {
               Client.field1109 = 64;
            }

            if(var2 == 3) {
               Client.field1109 = 32;
            }

            if(var2 == 4) {
               Client.field1109 = 0;
            }
         }

         if(var1 == 5) {
            Client.field1039 = var2;
         }

         if(var1 == 6) {
            Client.field1023 = var2;
         }

         if(var1 == 9) {
            Client.field1150 = var2;
         }

         if(var1 == 10) {
            if(var2 == 0) {
               Client.field1143 = 127;
            }

            if(var2 == 1) {
               Client.field1143 = 96;
            }

            if(var2 == 2) {
               Client.field1143 = 64;
            }

            if(var2 == 3) {
               Client.field1143 = 32;
            }

            if(var2 == 4) {
               Client.field1143 = 0;
            }
         }

         if(var1 == 17) {
            Client.field954 = var2 & '\uffff';
         }

         if(var1 == 18) {
            Client.field940 = (class92)GroundObject.forOrdinal(class262.method4753(), var2);
            if(Client.field940 == null) {
               Client.field940 = class92.field1408;
            }
         }

         if(var1 == 19) {
            if(var2 == -1) {
               Client.field1031 = -1;
            } else {
               Client.field1031 = var2 & 2047;
            }
         }

         if(var1 == 22) {
            Client.field1089 = (class92)GroundObject.forOrdinal(class262.method4753(), var2);
            if(Client.field1089 == null) {
               Client.field1089 = class92.field1408;
            }
         }

      }
   }

   @ObfuscatedName("hd")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-92"
   )
   static void method11() {
      for(int var0 = 0; var0 < Client.menuOptionCount; ++var0) {
         int var2 = Client.menuTypes[var0];
         boolean var1 = var2 == 57 || var2 == 58 || var2 == 1007 || var2 == 25 || var2 == 30;
         if(var1) {
            if(var0 < Client.menuOptionCount - 1) {
               for(int var3 = var0; var3 < Client.menuOptionCount - 1; ++var3) {
                  Client.menuOptions[var3] = Client.menuOptions[var3 + 1];
                  Client.menuTargets[var3] = Client.menuTargets[var3 + 1];
                  Client.menuTypes[var3] = Client.menuTypes[var3 + 1];
                  Client.menuIdentifiers[var3] = Client.menuIdentifiers[var3 + 1];
                  Client.menuActionParams0[var3] = Client.menuActionParams0[var3 + 1];
                  Client.menuActionParams1[var3] = Client.menuActionParams1[var3 + 1];
                  Client.field1048[var3] = Client.field1048[var3 + 1];
               }
            }

            --Client.menuOptionCount;
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(ILcc;ZB)I",
      garbageValue = "-70"
   )
   static int method15(int var0, Script var1, boolean var2) {
      Widget var3 = var2?class269.field3661:DecorativeObject.field2164;
      if(var0 == 1500) {
         class84.intStack[++class84.intStackSize - 1] = var3.relativeX;
         return 1;
      } else if(var0 == 1501) {
         class84.intStack[++class84.intStackSize - 1] = var3.relativeY;
         return 1;
      } else if(var0 == 1502) {
         class84.intStack[++class84.intStackSize - 1] = var3.width;
         return 1;
      } else if(var0 == 1503) {
         class84.intStack[++class84.intStackSize - 1] = var3.height;
         return 1;
      } else if(var0 == 1504) {
         class84.intStack[++class84.intStackSize - 1] = var3.isHidden?1:0;
         return 1;
      } else if(var0 == 1505) {
         class84.intStack[++class84.intStackSize - 1] = var3.parentId;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("if")
   @ObfuscatedSignature(
      signature = "(Lhg;III)V",
      garbageValue = "653022119"
   )
   static final void method14(Widget var0, int var1, int var2) {
      if(Client.field1117 == null && !Client.isMenuOpen) {
         if(var0 != null && class54.method789(var0) != null) {
            Client.field1117 = var0;
            Client.field1076 = class54.method789(var0);
            Client.field1012 = var1;
            Client.field1078 = var2;
            ItemLayer.field1779 = 0;
            Client.field1086 = false;
            int var3 = Client.menuOptionCount - 1;
            if(var3 != -1) {
               class74.method1135(var3);
            }

         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)Ljava/lang/String;",
      garbageValue = "-96"
   )
   public static String method13(CharSequence var0) {
      String var1 = PacketBuffer.method3414(class72.method1124(var0));
      if(var1 == null) {
         var1 = "";
      }

      return var1;
   }
}
