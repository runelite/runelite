import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gy")
@Implements("ItemComposition")
public class ItemComposition extends CacheableNode {
   @ObfuscatedName("bl")
   public boolean field2950 = false;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -768786393
   )
   @Export("isStackable")
   public int isStackable = 0;
   @ObfuscatedName("h")
   static class182 field2954;
   @ObfuscatedName("f")
   @Export("isMembersWorld")
   static boolean isMembersWorld;
   @ObfuscatedName("r")
   static NodeCache field2956 = new NodeCache(64);
   @ObfuscatedName("x")
   @Export("itemModelCache")
   static NodeCache itemModelCache = new NodeCache(50);
   @ObfuscatedName("z")
   @Export("itemSpriteCache")
   public static NodeCache itemSpriteCache = new NodeCache(200);
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1044485747
   )
   @Export("id")
   public int id;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 364771765
   )
   @Export("inventoryModel")
   int inventoryModel;
   @ObfuscatedName("y")
   @Export("name")
   public String name = "null";
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 16998821
   )
   @Export("team")
   int team = -2;
   @ObfuscatedName("u")
   @Export("textureToReplace")
   short[] textureToReplace;
   @ObfuscatedName("aw")
   @Export("inventoryActions")
   public String[] inventoryActions = new String[]{null, null, null, null, "Drop"};
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1632601839
   )
   @Export("zoom2d")
   public int zoom2d = 2000;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -888739255
   )
   @Export("xan2d")
   public int xan2d = 0;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -723758037
   )
   @Export("yan2d")
   public int yan2d = 0;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1187125985
   )
   @Export("zan2d")
   public int zan2d = 0;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 877114607
   )
   @Export("offsetX2d")
   public int offsetX2d = 0;
   @ObfuscatedName("w")
   @Export("colourToReplace")
   short[] colourToReplace;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -1077088453
   )
   @Export("femaleModel1")
   int femaleModel1 = -1;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -923448495
   )
   @Export("price")
   public int price = 1;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = 239029247
   )
   int field2974 = -1;
   @ObfuscatedName("af")
   @Export("groundActions")
   public String[] groundActions = new String[]{null, null, "Take", null, null};
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = -1028117313
   )
   public int field2976 = 0;
   @ObfuscatedName("q")
   @Export("textToReplaceWith")
   short[] textToReplaceWith;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -488435783
   )
   @Export("resizeY")
   int resizeY = 128;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 139402617
   )
   @Export("femaleHeadModel2")
   int femaleHeadModel2 = -1;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -65714485
   )
   @Export("offsetY2d")
   public int offsetY2d = 0;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 1066132673
   )
   @Export("maleModel")
   int maleModel = -1;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 1220443541
   )
   @Export("resizeZ")
   int resizeZ = 128;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 1990497963
   )
   @Export("femaleOffset")
   int femaleOffset = 0;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -1773455055
   )
   @Export("maleModel2")
   int maleModel2 = -1;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -245987609
   )
   @Export("femaleModel2")
   int femaleModel2 = -1;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -1378181691
   )
   @Export("maleHeadModel")
   int maleHeadModel = -1;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -1492358941
   )
   @Export("maleHeadModel2")
   int maleHeadModel2 = -1;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -1909162613
   )
   @Export("femaleModel")
   int femaleModel = -1;
   @ObfuscatedName("m")
   @Export("colourToReplaceWith")
   short[] colourToReplaceWith;
   @ObfuscatedName("ah")
   @Export("countObj")
   int[] countObj;
   @ObfuscatedName("ak")
   @Export("countCo")
   int[] countCo;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -164110671
   )
   @Export("note")
   public int note = -1;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -48486993
   )
   @Export("notedTemplate")
   public int notedTemplate = -1;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -110636049
   )
   @Export("resizeX")
   int resizeX = 128;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = 1200554821
   )
   int field2995 = -1;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -1433712607
   )
   @Export("femaleHeadModel")
   int femaleHeadModel = -1;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = 1903969427
   )
   @Export("ambient")
   public int ambient = 0;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = -207412781
   )
   @Export("contrast")
   public int contrast = 0;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = -936676127
   )
   public int field3000 = -1;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -1681807773
   )
   @Export("maleOffset")
   int maleOffset = 0;
   @ObfuscatedName("ab")
   @Export("isMembers")
   public boolean isMembers = false;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = 726526273
   )
   public int field3003 = -1;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 357954837
   )
   @Export("maleModel1")
   int maleModel1 = -1;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-15"
   )
   void method3724() {
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-2132300773"
   )
   @Export("populateFromBuffer")
   void populateFromBuffer(Buffer var1, int var2) {
      if(var2 == 1) {
         this.inventoryModel = var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.name = var1.readString();
      } else if(var2 == 4) {
         this.zoom2d = var1.readUnsignedShort();
      } else if(var2 == 5) {
         this.xan2d = var1.readUnsignedShort();
      } else if(var2 == 6) {
         this.yan2d = var1.readUnsignedShort();
      } else if(var2 == 7) {
         this.offsetX2d = var1.readUnsignedShort();
         if(this.offsetX2d > 32767) {
            this.offsetX2d -= 65536;
         }
      } else if(var2 == 8) {
         this.offsetY2d = var1.readUnsignedShort();
         if(this.offsetY2d > 32767) {
            this.offsetY2d -= 65536;
         }
      } else if(var2 == 11) {
         this.isStackable = 1;
      } else if(var2 == 12) {
         this.price = var1.readInt();
      } else if(var2 == 16) {
         this.isMembers = true;
      } else if(var2 == 23) {
         this.maleModel = var1.readUnsignedShort();
         this.maleOffset = var1.readUnsignedByte();
      } else if(var2 == 24) {
         this.maleModel1 = var1.readUnsignedShort();
      } else if(var2 == 25) {
         this.femaleModel = var1.readUnsignedShort();
         this.femaleOffset = var1.readUnsignedByte();
      } else if(var2 == 26) {
         this.femaleModel1 = var1.readUnsignedShort();
      } else if(var2 >= 30 && var2 < 35) {
         this.groundActions[var2 - 30] = var1.readString();
         if(this.groundActions[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.groundActions[var2 - 30] = null;
         }
      } else if(var2 >= 35 && var2 < 40) {
         this.inventoryActions[var2 - 35] = var1.readString();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.readUnsignedByte();
            this.colourToReplace = new short[var3];
            this.colourToReplaceWith = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.colourToReplace[var4] = (short)var1.readUnsignedShort();
               this.colourToReplaceWith[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 == 41) {
            var3 = var1.readUnsignedByte();
            this.textureToReplace = new short[var3];
            this.textToReplaceWith = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.textureToReplace[var4] = (short)var1.readUnsignedShort();
               this.textToReplaceWith[var4] = (short)var1.readUnsignedShort();
            }
         } else if(var2 == 42) {
            this.team = var1.readByte();
         } else if(var2 == 65) {
            this.field2950 = true;
         } else if(var2 == 78) {
            this.maleModel2 = var1.readUnsignedShort();
         } else if(var2 == 79) {
            this.femaleModel2 = var1.readUnsignedShort();
         } else if(var2 == 90) {
            this.maleHeadModel = var1.readUnsignedShort();
         } else if(var2 == 91) {
            this.femaleHeadModel = var1.readUnsignedShort();
         } else if(var2 == 92) {
            this.maleHeadModel2 = var1.readUnsignedShort();
         } else if(var2 == 93) {
            this.femaleHeadModel2 = var1.readUnsignedShort();
         } else if(var2 == 95) {
            this.zan2d = var1.readUnsignedShort();
         } else if(var2 == 97) {
            this.note = var1.readUnsignedShort();
         } else if(var2 == 98) {
            this.notedTemplate = var1.readUnsignedShort();
         } else if(var2 >= 100 && var2 < 110) {
            if(this.countObj == null) {
               this.countObj = new int[10];
               this.countCo = new int[10];
            }

            this.countObj[var2 - 100] = var1.readUnsignedShort();
            this.countCo[var2 - 100] = var1.readUnsignedShort();
         } else if(var2 == 110) {
            this.resizeX = var1.readUnsignedShort();
         } else if(var2 == 111) {
            this.resizeY = var1.readUnsignedShort();
         } else if(var2 == 112) {
            this.resizeZ = var1.readUnsignedShort();
         } else if(var2 == 113) {
            this.ambient = var1.readByte();
         } else if(var2 == 114) {
            this.contrast = var1.readByte() * 5;
         } else if(var2 == 115) {
            this.field2976 = var1.readUnsignedByte();
         } else if(var2 == 139) {
            this.field2974 = var1.readUnsignedShort();
         } else if(var2 == 140) {
            this.field2995 = var1.readUnsignedShort();
         } else if(var2 == 148) {
            this.field3003 = var1.readUnsignedShort();
         } else if(var2 == 149) {
            this.field3000 = var1.readUnsignedShort();
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LItemComposition;LItemComposition;I)V",
      garbageValue = "1536457537"
   )
   void method3729(ItemComposition var1, ItemComposition var2) {
      this.inventoryModel = var1.inventoryModel;
      this.zoom2d = var1.zoom2d;
      this.xan2d = var1.xan2d;
      this.yan2d = var1.yan2d;
      this.zan2d = var1.zan2d;
      this.offsetX2d = var1.offsetX2d;
      this.offsetY2d = var1.offsetY2d;
      this.colourToReplace = var1.colourToReplace;
      this.colourToReplaceWith = var1.colourToReplaceWith;
      this.textureToReplace = var1.textureToReplace;
      this.textToReplaceWith = var1.textToReplaceWith;
      this.isStackable = var1.isStackable;
      this.name = var2.name;
      this.price = 0;
      this.isMembers = false;
      this.field2950 = false;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)LModelData;",
      garbageValue = "-1991926063"
   )
   public final ModelData method3730(int var1) {
      int var3;
      if(null != this.countObj && var1 > 1) {
         int var2 = -1;

         for(var3 = 0; var3 < 10; ++var3) {
            if(var1 >= this.countCo[var3] && this.countCo[var3] != 0) {
               var2 = this.countObj[var3];
            }
         }

         if(var2 != -1) {
            return class168.getItemDefinition(var2).method3730(1);
         }
      }

      ModelData var4 = ModelData.method1563(class38.field796, this.inventoryModel, 0);
      if(null == var4) {
         return null;
      } else {
         if(this.resizeX != 128 || this.resizeY != 128 || this.resizeZ != 128) {
            var4.method1536(this.resizeX, this.resizeY, this.resizeZ);
         }

         if(this.colourToReplace != null) {
            for(var3 = 0; var3 < this.colourToReplace.length; ++var3) {
               var4.method1579(this.colourToReplace[var3], this.colourToReplaceWith[var3]);
            }
         }

         if(this.textureToReplace != null) {
            for(var3 = 0; var3 < this.textureToReplace.length; ++var3) {
               var4.method1541(this.textureToReplace[var3], this.textToReplaceWith[var3]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(ZI)Z",
      garbageValue = "1979809964"
   )
   @Export("readyWorn")
   public final boolean readyWorn(boolean var1) {
      int var2 = this.maleModel;
      int var3 = this.maleModel1;
      int var4 = this.maleModel2;
      if(var1) {
         var2 = this.femaleModel;
         var3 = this.femaleModel1;
         var4 = this.femaleModel2;
      }

      if(var2 == -1) {
         return true;
      } else {
         boolean var5 = true;
         if(!class38.field796.method3413(var2, 0)) {
            var5 = false;
         }

         if(var3 != -1 && !class38.field796.method3413(var3, 0)) {
            var5 = false;
         }

         if(var4 != -1 && !class38.field796.method3413(var4, 0)) {
            var5 = false;
         }

         return var5;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(ZI)LModelData;",
      garbageValue = "1280302164"
   )
   @Export("getWornModelData")
   public final ModelData getWornModelData(boolean var1) {
      int var2 = this.maleModel;
      int var3 = this.maleModel1;
      int var4 = this.maleModel2;
      if(var1) {
         var2 = this.femaleModel;
         var3 = this.femaleModel1;
         var4 = this.femaleModel2;
      }

      if(var2 == -1) {
         return null;
      } else {
         ModelData var5 = ModelData.method1563(class38.field796, var2, 0);
         if(var3 != -1) {
            ModelData var6 = ModelData.method1563(class38.field796, var3, 0);
            if(var4 != -1) {
               ModelData var7 = ModelData.method1563(class38.field796, var4, 0);
               ModelData[] var8 = new ModelData[]{var5, var6, var7};
               var5 = new ModelData(var8, 3);
            } else {
               ModelData[] var10 = new ModelData[]{var5, var6};
               var5 = new ModelData(var10, 2);
            }
         }

         if(!var1 && this.maleOffset != 0) {
            var5.method1558(0, this.maleOffset, 0);
         }

         if(var1 && this.femaleOffset != 0) {
            var5.method1558(0, this.femaleOffset, 0);
         }

         int var9;
         if(null != this.colourToReplace) {
            for(var9 = 0; var9 < this.colourToReplace.length; ++var9) {
               var5.method1579(this.colourToReplace[var9], this.colourToReplaceWith[var9]);
            }
         }

         if(this.textureToReplace != null) {
            for(var9 = 0; var9 < this.textureToReplace.length; ++var9) {
               var5.method1541(this.textureToReplace[var9], this.textToReplaceWith[var9]);
            }
         }

         return var5;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(ZI)Z",
      garbageValue = "-369297066"
   )
   public final boolean method3735(boolean var1) {
      int var2 = this.maleHeadModel;
      int var3 = this.maleHeadModel2;
      if(var1) {
         var2 = this.femaleHeadModel;
         var3 = this.femaleHeadModel2;
      }

      if(var2 == -1) {
         return true;
      } else {
         boolean var4 = true;
         if(!class38.field796.method3413(var2, 0)) {
            var4 = false;
         }

         if(var3 != -1 && !class38.field796.method3413(var3, 0)) {
            var4 = false;
         }

         return var4;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "0"
   )
   public int method3737() {
      return this.team != -1 && null != this.inventoryActions?(this.team >= 0?(this.inventoryActions[this.team] != null?this.team:-1):("Drop".equalsIgnoreCase(this.inventoryActions[4])?4:-1)):-1;
   }

   @ObfuscatedName("au")
   @ObfuscatedSignature(
      signature = "(LActor;I)V",
      garbageValue = "-875995605"
   )
   static final void method3742(Actor var0) {
      var0.poseAnimation = var0.idlePoseAnimation;
      if(var0.field655 == 0) {
         var0.field601 = 0;
      } else {
         if(var0.animation != -1 && var0.actionAnimationDisable == 0) {
            Sequence var1 = XClanMember.getAnimation(var0.animation);
            if(var0.field660 > 0 && var1.precedenceAnimating == 0) {
               ++var0.field601;
               return;
            }

            if(var0.field660 <= 0 && var1.priority == 0) {
               ++var0.field601;
               return;
            }
         }

         int var10 = var0.x;
         int var2 = var0.y;
         int var3 = 128 * var0.pathX[var0.field655 - 1] + var0.field634 * 64;
         int var4 = var0.pathY[var0.field655 - 1] * 128 + var0.field634 * 64;
         if(var10 < var3) {
            if(var2 < var4) {
               var0.field652 = 1280;
            } else if(var2 > var4) {
               var0.field652 = 1792;
            } else {
               var0.field652 = 1536;
            }
         } else if(var10 > var3) {
            if(var2 < var4) {
               var0.field652 = 768;
            } else if(var2 > var4) {
               var0.field652 = 256;
            } else {
               var0.field652 = 512;
            }
         } else if(var2 < var4) {
            var0.field652 = 1024;
         } else if(var2 > var4) {
            var0.field652 = 0;
         }

         byte var5 = var0.field658[var0.field655 - 1];
         if(var3 - var10 <= 256 && var3 - var10 >= -256 && var4 - var2 <= 256 && var4 - var2 >= -256) {
            int var6 = var0.field652 - var0.angle & 2047;
            if(var6 > 1024) {
               var6 -= 2048;
            }

            int var7 = var0.field624;
            if(var6 >= -256 && var6 <= 256) {
               var7 = var0.field627;
            } else if(var6 >= 256 && var6 < 768) {
               var7 = var0.field612;
            } else if(var6 >= -768 && var6 <= -256) {
               var7 = var0.field611;
            }

            if(var7 == -1) {
               var7 = var0.field627;
            }

            var0.poseAnimation = var7;
            int var8 = 4;
            boolean var9 = true;
            if(var0 instanceof NPC) {
               var9 = ((NPC)var0).composition.isClickable;
            }

            if(var9) {
               if(var0.field652 != var0.angle && var0.interacting == -1 && var0.field654 != 0) {
                  var8 = 2;
               }

               if(var0.field655 > 2) {
                  var8 = 6;
               }

               if(var0.field655 > 3) {
                  var8 = 8;
               }

               if(var0.field601 > 0 && var0.field655 > 1) {
                  var8 = 8;
                  --var0.field601;
               }
            } else {
               if(var0.field655 > 1) {
                  var8 = 6;
               }

               if(var0.field655 > 2) {
                  var8 = 8;
               }

               if(var0.field601 > 0 && var0.field655 > 1) {
                  var8 = 8;
                  --var0.field601;
               }
            }

            if(var5 == 2) {
               var8 <<= 1;
            }

            if(var8 >= 8 && var0.field627 == var0.poseAnimation && var0.field613 != -1) {
               var0.poseAnimation = var0.field613;
            }

            if(var3 != var10 || var2 != var4) {
               if(var10 < var3) {
                  var0.x += var8;
                  if(var0.x > var3) {
                     var0.x = var3;
                  }
               } else if(var10 > var3) {
                  var0.x -= var8;
                  if(var0.x < var3) {
                     var0.x = var3;
                  }
               }

               if(var2 < var4) {
                  var0.y += var8;
                  if(var0.y > var4) {
                     var0.y = var4;
                  }
               } else if(var2 > var4) {
                  var0.y -= var8;
                  if(var0.y < var4) {
                     var0.y = var4;
                  }
               }
            }

            if(var0.x == var3 && var0.y == var4) {
               --var0.field655;
               if(var0.field660 > 0) {
                  --var0.field660;
               }
            }

         } else {
            var0.x = var3;
            var0.y = var4;
            --var0.field655;
            if(var0.field660 > 0) {
               --var0.field660;
            }

         }
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "809964311"
   )
   @Export("loadBuffer")
   void loadBuffer(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.populateFromBuffer(var1, var2);
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)LItemComposition;",
      garbageValue = "1854228008"
   )
   public ItemComposition method3772(int var1) {
      if(null != this.countObj && var1 > 1) {
         int var2 = -1;

         for(int var3 = 0; var3 < 10; ++var3) {
            if(var1 >= this.countCo[var3] && this.countCo[var3] != 0) {
               var2 = this.countObj[var3];
            }
         }

         if(var2 != -1) {
            return class168.getItemDefinition(var2);
         }
      }

      return this;
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(ZI)LModelData;",
      garbageValue = "2007017777"
   )
   public final ModelData method3773(boolean var1) {
      int var2 = this.maleHeadModel;
      int var3 = this.maleHeadModel2;
      if(var1) {
         var2 = this.femaleHeadModel;
         var3 = this.femaleHeadModel2;
      }

      if(var2 == -1) {
         return null;
      } else {
         ModelData var4 = ModelData.method1563(class38.field796, var2, 0);
         if(var3 != -1) {
            ModelData var7 = ModelData.method1563(class38.field796, var3, 0);
            ModelData[] var6 = new ModelData[]{var4, var7};
            var4 = new ModelData(var6, 2);
         }

         int var5;
         if(this.colourToReplace != null) {
            for(var5 = 0; var5 < this.colourToReplace.length; ++var5) {
               var4.method1579(this.colourToReplace[var5], this.colourToReplaceWith[var5]);
            }
         }

         if(this.textureToReplace != null) {
            for(var5 = 0; var5 < this.textureToReplace.length; ++var5) {
               var4.method1541(this.textureToReplace[var5], this.textToReplaceWith[var5]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(LItemComposition;LItemComposition;I)V",
      garbageValue = "-1925365813"
   )
   void method3789(ItemComposition var1, ItemComposition var2) {
      this.inventoryModel = var1.inventoryModel;
      this.zoom2d = var1.zoom2d;
      this.xan2d = var1.xan2d;
      this.yan2d = var1.yan2d;
      this.zan2d = var1.zan2d;
      this.offsetX2d = var1.offsetX2d;
      this.offsetY2d = var1.offsetY2d;
      this.colourToReplace = var1.colourToReplace;
      this.colourToReplaceWith = var1.colourToReplaceWith;
      this.textureToReplace = var1.textureToReplace;
      this.textToReplaceWith = var1.textToReplaceWith;
      this.name = var2.name;
      this.isMembers = var2.isMembers;
      this.price = var2.price;
      this.isStackable = 1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)LModel;",
      garbageValue = "-324132110"
   )
   @Export("getModel")
   public final Model getModel(int var1) {
      if(null != this.countObj && var1 > 1) {
         int var2 = -1;

         for(int var3 = 0; var3 < 10; ++var3) {
            if(var1 >= this.countCo[var3] && this.countCo[var3] != 0) {
               var2 = this.countObj[var3];
            }
         }

         if(var2 != -1) {
            return class168.getItemDefinition(var2).getModel(1);
         }
      }

      Model var5 = (Model)itemModelCache.get((long)this.id);
      if(var5 != null) {
         return var5;
      } else {
         ModelData var6 = ModelData.method1563(class38.field796, this.inventoryModel, 0);
         if(null == var6) {
            return null;
         } else {
            if(this.resizeX != 128 || this.resizeY != 128 || this.resizeZ != 128) {
               var6.method1536(this.resizeX, this.resizeY, this.resizeZ);
            }

            int var4;
            if(this.colourToReplace != null) {
               for(var4 = 0; var4 < this.colourToReplace.length; ++var4) {
                  var6.method1579(this.colourToReplace[var4], this.colourToReplaceWith[var4]);
               }
            }

            if(null != this.textureToReplace) {
               for(var4 = 0; var4 < this.textureToReplace.length; ++var4) {
                  var6.method1541(this.textureToReplace[var4], this.textToReplaceWith[var4]);
               }
            }

            var5 = var6.method1544(this.ambient + 64, 768 + this.contrast, -50, -10, -50);
            var5.field1360 = true;
            itemModelCache.put(var5, (long)this.id);
            return var5;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lclass182;II)LModIcon;",
      garbageValue = "1376371257"
   )
   public static ModIcon method3800(class182 var0, int var1) {
      if(!MessageNode.method217(var0, var1)) {
         return null;
      } else {
         ModIcon var3 = new ModIcon();
         var3.width = class225.field3228;
         var3.originalHeight = class225.field3227;
         var3.offsetX = class225.field3229[0];
         var3.offsetY = class155.field2105[0];
         var3.originalWidth = class172.field2351[0];
         var3.height = class225.field3230[0];
         var3.palette = class225.field3231;
         var3.pixels = class225.field3232[0];
         class0.method13();
         return var3;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(LItemComposition;LItemComposition;I)V",
      garbageValue = "670305296"
   )
   void method3801(ItemComposition var1, ItemComposition var2) {
      this.inventoryModel = var1.inventoryModel;
      this.zoom2d = var1.zoom2d;
      this.xan2d = var1.xan2d;
      this.yan2d = var1.yan2d;
      this.zan2d = var1.zan2d;
      this.offsetX2d = var1.offsetX2d;
      this.offsetY2d = var1.offsetY2d;
      this.colourToReplace = var2.colourToReplace;
      this.colourToReplaceWith = var2.colourToReplaceWith;
      this.textureToReplace = var2.textureToReplace;
      this.textToReplaceWith = var2.textToReplaceWith;
      this.name = var2.name;
      this.isMembers = var2.isMembers;
      this.isStackable = var2.isStackable;
      this.maleModel = var2.maleModel;
      this.maleModel1 = var2.maleModel1;
      this.maleModel2 = var2.maleModel2;
      this.femaleModel = var2.femaleModel;
      this.femaleModel1 = var2.femaleModel1;
      this.femaleModel2 = var2.femaleModel2;
      this.maleHeadModel = var2.maleHeadModel;
      this.maleHeadModel2 = var2.maleHeadModel2;
      this.femaleHeadModel = var2.femaleHeadModel;
      this.femaleHeadModel2 = var2.femaleHeadModel2;
      this.field2976 = var2.field2976;
      this.groundActions = var2.groundActions;
      this.inventoryActions = new String[5];
      if(null != var2.inventoryActions) {
         for(int var3 = 0; var3 < 4; ++var3) {
            this.inventoryActions[var3] = var2.inventoryActions[var3];
         }
      }

      this.inventoryActions[4] = "Discard";
      this.price = 0;
   }
}
