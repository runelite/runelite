import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("au")
public class class45 extends CacheableNode {
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1599782665
   )
   int field1013;
   @ObfuscatedName("e")
   public static class170 field1014;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -542755147
   )
   int field1015 = 128;
   @ObfuscatedName("f")
   public static class170 field1016;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -392695701
   )
   int field1017;
   @ObfuscatedName("l")
   short[] field1018;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -308420863
   )
   int field1019 = 0;
   @ObfuscatedName("k")
   short[] field1020;
   @ObfuscatedName("w")
   short[] field1022;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 2063752361
   )
   public int field1023 = -1;
   @ObfuscatedName("t")
   static NodeCache field1024 = new NodeCache(30);
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 2060034723
   )
   int field1025 = 128;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -94929147
   )
   int field1026 = 0;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 737406257
   )
   int field1027 = 0;
   @ObfuscatedName("c")
   short[] field1028;
   @ObfuscatedName("n")
   static NodeCache field1029 = new NodeCache(64);

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)LModel;",
      garbageValue = "-1348582916"
   )
   public final Model method921(int var1) {
      Model var2 = (Model)field1024.get((long)this.field1017);
      if(null == var2) {
         ModelData var3 = ModelData.method2236(field1014, this.field1013, 0);
         if(null == var3) {
            return null;
         }

         int var4;
         if(null != this.field1020) {
            for(var4 = 0; var4 < this.field1020.length; ++var4) {
               var3.method2248(this.field1020[var4], this.field1028[var4]);
            }
         }

         if(this.field1022 != null) {
            for(var4 = 0; var4 < this.field1022.length; ++var4) {
               var3.method2249(this.field1022[var4], this.field1018[var4]);
            }
         }

         var2 = var3.method2256(64 + this.field1027, 850 + this.field1019, -30, -50, -30);
         field1024.put(var2, (long)this.field1017);
      }

      Model var5;
      if(this.field1023 != -1 && var1 != -1) {
         var5 = class62.getAnimation(this.field1023).method884(var2, var1);
      } else {
         var5 = var2.method2317(true);
      }

      if(this.field1015 != 128 || this.field1025 != 128) {
         var5.method2333(this.field1015, this.field1025, this.field1015);
      }

      if(this.field1026 != 0) {
         if(this.field1026 == 90) {
            var5.method2328();
         }

         if(this.field1026 == 180) {
            var5.method2328();
            var5.method2328();
         }

         if(this.field1026 == 270) {
            var5.method2328();
            var5.method2328();
            var5.method2328();
         }
      }

      return var5;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "104"
   )
   void method923(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field1013 = var1.method2535();
      } else if(var2 == 2) {
         this.field1023 = var1.method2535();
      } else if(var2 == 4) {
         this.field1015 = var1.method2535();
      } else if(var2 == 5) {
         this.field1025 = var1.method2535();
      } else if(var2 == 6) {
         this.field1026 = var1.method2535();
      } else if(var2 == 7) {
         this.field1027 = var1.method2656();
      } else if(var2 == 8) {
         this.field1019 = var1.method2656();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.method2656();
            this.field1020 = new short[var3];
            this.field1028 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1020[var4] = (short)var1.method2535();
               this.field1028[var4] = (short)var1.method2535();
            }
         } else if(var2 == 41) {
            var3 = var1.method2656();
            this.field1022 = new short[var3];
            this.field1018 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1022[var4] = (short)var1.method2535();
               this.field1018[var4] = (short)var1.method2535();
            }
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "1235213362"
   )
   void method924(Buffer var1) {
      while(true) {
         int var2 = var1.method2656();
         if(var2 == 0) {
            return;
         }

         this.method923(var1, var2);
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)LItemComposition;",
      garbageValue = "-503467057"
   )
   @Export("getItemDefinition")
   public static ItemComposition getItemDefinition(int var0) {
      ItemComposition var1 = (ItemComposition)ItemComposition.field1155.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = ItemComposition.field1152.method3304(10, var0);
         var1 = new ItemComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.loadBuffer(new Buffer(var2));
         }

         var1.method1103();
         if(var1.field1192 != -1) {
            var1.method1106(getItemDefinition(var1.field1192), getItemDefinition(var1.note));
         }

         if(var1.field1201 != -1) {
            var1.method1107(getItemDefinition(var1.field1201), getItemDefinition(var1.field1188));
         }

         if(var1.field1203 != -1) {
            var1.method1155(getItemDefinition(var1.field1203), getItemDefinition(var1.field1202));
         }

         if(!ItemComposition.isMembersWorld && var1.isMembers) {
            var1.name = "Members object";
            var1.field1199 = false;
            var1.groundActions = null;
            var1.inventoryActions = null;
            var1.field1193 = 0;
         }

         ItemComposition.field1155.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "30538549"
   )
   static final void method934() {
      class18.method192();
      if(Projectile.field124 == null) {
         if(null == Client.field452) {
            int var0 = class143.field2198;
            int var1;
            int var2;
            int var3;
            int var4;
            int var5;
            int var6;
            if(Client.isMenuOpen) {
               if(var0 != 1 && (ChatMessages.field276 || var0 != 4)) {
                  var1 = class143.field2192;
                  var2 = class143.field2199;
                  if(var1 < class133.menuX - 10 || var1 > class133.menuX + class107.menuWidth + 10 || var2 < class0.menuY - 10 || var2 > 10 + class0.menuY + class85.menuHeight) {
                     Client.isMenuOpen = false;
                     class50.method1014(class133.menuX, class0.menuY, class107.menuWidth, class85.menuHeight);
                  }
               }

               if(var0 == 1 || !ChatMessages.field276 && var0 == 4) {
                  var1 = class133.menuX;
                  var2 = class0.menuY;
                  var3 = class107.menuWidth;
                  var4 = class143.field2197;
                  var5 = class143.field2207;
                  var6 = -1;

                  int var7;
                  int var8;
                  for(var7 = 0; var7 < Client.menuOptionCount; ++var7) {
                     var8 = 15 * (Client.menuOptionCount - 1 - var7) + var2 + 31;
                     if(var4 > var1 && var4 < var1 + var3 && var5 > var8 - 13 && var5 < var8 + 3) {
                        var6 = var7;
                     }
                  }

                  if(var6 != -1 && var6 >= 0) {
                     var7 = Client.menuActionParams0[var6];
                     var8 = Client.menuActionParams1[var6];
                     int var9 = Client.menuTypes[var6];
                     int var10 = Client.menuIdentifiers[var6];
                     String var11 = Client.menuOptions[var6];
                     String var12 = Client.menuTargets[var6];
                     class38.menuAction(var7, var8, var9, var10, var11, var12, class143.field2197, class143.field2207);
                  }

                  Client.isMenuOpen = false;
                  class50.method1014(class133.menuX, class0.menuY, class107.menuWidth, class85.menuHeight);
               }
            } else {
               if((var0 == 1 || !ChatMessages.field276 && var0 == 4) && Client.menuOptionCount > 0) {
                  var1 = Client.menuTypes[Client.menuOptionCount - 1];
                  if(var1 == 39 || var1 == 40 || var1 == 41 || var1 == 42 || var1 == 43 || var1 == 33 || var1 == 34 || var1 == 35 || var1 == 36 || var1 == 37 || var1 == 38 || var1 == 1005) {
                     var2 = Client.menuActionParams0[Client.menuOptionCount - 1];
                     var3 = Client.menuActionParams1[Client.menuOptionCount - 1];
                     Widget var13 = class153.method3170(var3);
                     if(class10.method124(class93.method2130(var13)) || ChatMessages.method231(class93.method2130(var13))) {
                        if(null != Projectile.field124 && !Client.field399 && Client.field419 != 1 && !class1.method12(Client.menuOptionCount - 1) && Client.menuOptionCount > 0) {
                           var5 = Client.field393;
                           var6 = Client.field417;
                           class127.method2803(class23.field603, var5, var6);
                           class23.field603 = null;
                        }

                        Client.field399 = false;
                        Client.field402 = 0;
                        if(null != Projectile.field124) {
                           MessageNode.method750(Projectile.field124);
                        }

                        Projectile.field124 = class153.method3170(var3);
                        Client.field395 = var2;
                        Client.field393 = class143.field2197;
                        Client.field417 = class143.field2207;
                        if(Client.menuOptionCount > 0) {
                           var5 = Client.menuOptionCount - 1;
                           class23.field603 = new class32();
                           class23.field603.field718 = Client.menuActionParams0[var5];
                           class23.field603.field714 = Client.menuActionParams1[var5];
                           class23.field603.field708 = Client.menuTypes[var5];
                           class23.field603.field710 = Client.menuIdentifiers[var5];
                           class23.field603.field709 = Client.menuOptions[var5];
                        }

                        MessageNode.method750(Projectile.field124);
                        return;
                     }
                  }
               }

               if((var0 == 1 || !ChatMessages.field276 && var0 == 4) && (Client.field419 == 1 && Client.menuOptionCount > 2 || class1.method12(Client.menuOptionCount - 1))) {
                  var0 = 2;
               }

               if((var0 == 1 || !ChatMessages.field276 && var0 == 4) && Client.menuOptionCount > 0) {
                  var1 = Client.menuOptionCount - 1;
                  if(var1 >= 0) {
                     var2 = Client.menuActionParams0[var1];
                     var3 = Client.menuActionParams1[var1];
                     var4 = Client.menuTypes[var1];
                     var5 = Client.menuIdentifiers[var1];
                     String var14 = Client.menuOptions[var1];
                     String var15 = Client.menuTargets[var1];
                     class38.menuAction(var2, var3, var4, var5, var14, var15, class143.field2197, class143.field2207);
                  }
               }

               if(var0 == 2 && Client.menuOptionCount > 0) {
                  Projectile.method89(class143.field2197, class143.field2207);
               }
            }

         }
      }
   }
}
