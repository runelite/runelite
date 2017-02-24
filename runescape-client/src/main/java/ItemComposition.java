import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gv")
@Implements("ItemComposition")
public class ItemComposition extends CacheableNode {
   @ObfuscatedName("y")
   @Export("textureToReplace")
   short[] textureToReplace;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = -1135969071
   )
   public int field2948 = 0;
   @ObfuscatedName("n")
   static class182 field2949;
   @ObfuscatedName("c")
   @Export("isMembersWorld")
   static boolean isMembersWorld;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = 671357039
   )
   public int field2952 = 0;
   @ObfuscatedName("o")
   static NodeCache field2953 = new NodeCache(64);
   @ObfuscatedName("ab")
   @Export("countCo")
   int[] countCo;
   @ObfuscatedName("s")
   @Export("itemSpriteCache")
   static NodeCache itemSpriteCache = new NodeCache(200);
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 329537559
   )
   @Export("id")
   public int id;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 883037489
   )
   @Export("inventoryModel")
   int inventoryModel;
   @ObfuscatedName("f")
   @Export("name")
   public String name = "null";
   @ObfuscatedName("z")
   @Export("colourToReplace")
   short[] colourToReplace;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 88523295
   )
   public static int field2960;
   @ObfuscatedName("r")
   static class182 field2961;
   @ObfuscatedName("w")
   @Export("textToReplaceWith")
   short[] textToReplaceWith;
   @ObfuscatedName("ar")
   @Export("countObj")
   int[] countObj;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1155207237
   )
   @Export("offsetX2d")
   public int offsetX2d = 0;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1821835943
   )
   @Export("yan2d")
   public int yan2d = 0;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -1562610985
   )
   @Export("zan2d")
   public int zan2d = 0;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1102300141
   )
   @Export("xan2d")
   public int xan2d = 0;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 980778195
   )
   @Export("offsetY2d")
   public int offsetY2d = 0;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = 669095499
   )
   int field2969 = -1;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 128654257
   )
   @Export("price")
   public int price = 1;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -1901114997
   )
   @Export("notedTemplate")
   public int notedTemplate = -1;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 374829833
   )
   @Export("maleHeadModel2")
   int maleHeadModel2 = -1;
   @ObfuscatedName("am")
   @Export("inventoryActions")
   public String[] inventoryActions = new String[]{null, null, null, null, "Drop"};
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 872614589
   )
   @Export("team")
   int team = -2;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -828447755
   )
   @Export("maleModel")
   int maleModel = -1;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = -958992283
   )
   public int field2976 = -1;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 124563489
   )
   @Export("maleOffset")
   int maleOffset = 0;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -1856720071
   )
   @Export("femaleModel")
   int femaleModel = -1;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -1617468091
   )
   @Export("femaleModel1")
   int femaleModel1 = -1;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 1904756207
   )
   @Export("femaleOffset")
   int femaleOffset = 0;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -854065639
   )
   @Export("maleModel2")
   int maleModel2 = -1;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 1293926475
   )
   @Export("femaleModel2")
   int femaleModel2 = -1;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 1443719793
   )
   @Export("maleHeadModel")
   int maleHeadModel = -1;
   @ObfuscatedName("at")
   @Export("isMembers")
   public boolean isMembers = false;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 893925119
   )
   @Export("femaleHeadModel")
   int femaleHeadModel = -1;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 1597395083
   )
   @Export("femaleHeadModel2")
   int femaleHeadModel2 = -1;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -1197713097
   )
   @Export("maleModel1")
   int maleModel1 = -1;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -312820625
   )
   @Export("note")
   public int note = -1;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -404560283
   )
   @Export("zoom2d")
   public int zoom2d = 2000;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -180160769
   )
   @Export("resizeX")
   int resizeX = 128;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -1761768275
   )
   @Export("resizeY")
   int resizeY = 128;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -619109113
   )
   @Export("resizeZ")
   int resizeZ = 128;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 1945185303
   )
   @Export("isStackable")
   public int isStackable = 0;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = 101850937
   )
   public int field2995 = 0;
   @ObfuscatedName("t")
   @Export("colourToReplaceWith")
   short[] colourToReplaceWith;
   @ObfuscatedName("bj")
   public boolean field2997 = false;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = -1796066935
   )
   int field2998 = -1;
   @ObfuscatedName("m")
   @Export("itemModelCache")
   static NodeCache itemModelCache = new NodeCache(50);
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = 1876177727
   )
   public int field3000 = -1;
   @ObfuscatedName("au")
   @Export("groundActions")
   public String[] groundActions = new String[]{null, null, "Take", null, null};

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1183093068"
   )
   void method3662() {
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-1880272946"
   )
   @Export("populateFromBuffer")
   void populateFromBuffer(Buffer var1, int var2) {
      if(var2 == 1) {
         this.inventoryModel = var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.name = var1.method2868();
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
         this.price = var1.method2965();
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
         this.groundActions[var2 - 30] = var1.method2868();
         if(this.groundActions[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.groundActions[var2 - 30] = null;
         }
      } else if(var2 >= 35 && var2 < 40) {
         this.inventoryActions[var2 - 35] = var1.method2868();
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
            this.field2997 = true;
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
            if(null == this.countObj) {
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
            this.field2952 = var1.readByte();
         } else if(var2 == 114) {
            this.field2995 = var1.readByte() * 5;
         } else if(var2 == 115) {
            this.field2948 = var1.readUnsignedByte();
         } else if(var2 == 139) {
            this.field2998 = var1.readUnsignedShort();
         } else if(var2 == 140) {
            this.field2969 = var1.readUnsignedShort();
         } else if(var2 == 148) {
            this.field3000 = var1.readUnsignedShort();
         } else if(var2 == 149) {
            this.field2976 = var1.readUnsignedShort();
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LItemComposition;LItemComposition;I)V",
      garbageValue = "-2025992560"
   )
   void method3666(ItemComposition var1, ItemComposition var2) {
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
      this.field2948 = var2.field2948;
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

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(LItemComposition;LItemComposition;I)V",
      garbageValue = "919548648"
   )
   void method3667(ItemComposition var1, ItemComposition var2) {
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
      this.field2997 = false;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(II)LModel;",
      garbageValue = "1647271577"
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
            return class103.getItemDefinition(var2).getModel(1);
         }
      }

      Model var6 = (Model)itemModelCache.get((long)this.id);
      if(null != var6) {
         return var6;
      } else {
         ModelData var5 = ModelData.method1559(field2961, this.inventoryModel, 0);
         if(null == var5) {
            return null;
         } else {
            if(this.resizeX != 128 || this.resizeY != 128 || this.resizeZ != 128) {
               var5.method1529(this.resizeX, this.resizeY, this.resizeZ);
            }

            int var4;
            if(null != this.colourToReplace) {
               for(var4 = 0; var4 < this.colourToReplace.length; ++var4) {
                  var5.method1526(this.colourToReplace[var4], this.colourToReplaceWith[var4]);
               }
            }

            if(this.textureToReplace != null) {
               for(var4 = 0; var4 < this.textureToReplace.length; ++var4) {
                  var5.method1564(this.textureToReplace[var4], this.textToReplaceWith[var4]);
               }
            }

            var6 = var5.method1534(64 + this.field2952, 768 + this.field2995, -50, -10, -50);
            var6.field1402 = true;
            itemModelCache.put(var6, (long)this.id);
            return var6;
         }
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(ZI)Z",
      garbageValue = "-1750053063"
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
         if(!field2961.method3376(var2, 0)) {
            var5 = false;
         }

         if(var3 != -1 && !field2961.method3376(var3, 0)) {
            var5 = false;
         }

         if(var4 != -1 && !field2961.method3376(var4, 0)) {
            var5 = false;
         }

         return var5;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(IB)LItemComposition;",
      garbageValue = "120"
   )
   public ItemComposition method3672(int var1) {
      if(null != this.countObj && var1 > 1) {
         int var2 = -1;

         for(int var3 = 0; var3 < 10; ++var3) {
            if(var1 >= this.countCo[var3] && this.countCo[var3] != 0) {
               var2 = this.countObj[var3];
            }
         }

         if(var2 != -1) {
            return class103.getItemDefinition(var2);
         }
      }

      return this;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(ZI)Z",
      garbageValue = "-1018110920"
   )
   public final boolean method3673(boolean var1) {
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
         if(!field2961.method3376(var2, 0)) {
            var4 = false;
         }

         if(var3 != -1 && !field2961.method3376(var3, 0)) {
            var4 = false;
         }

         return var4;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-605278441"
   )
   public int method3675() {
      return this.team != -1 && this.inventoryActions != null?(this.team >= 0?(this.inventoryActions[this.team] != null?this.team:-1):("Drop".equalsIgnoreCase(this.inventoryActions[4])?4:-1)):-1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ZB)LModelData;",
      garbageValue = "125"
   )
   public final ModelData method3685(boolean var1) {
      int var2 = this.maleHeadModel;
      int var3 = this.maleHeadModel2;
      if(var1) {
         var2 = this.femaleHeadModel;
         var3 = this.femaleHeadModel2;
      }

      if(var2 == -1) {
         return null;
      } else {
         ModelData var4 = ModelData.method1559(field2961, var2, 0);
         if(var3 != -1) {
            ModelData var7 = ModelData.method1559(field2961, var3, 0);
            ModelData[] var6 = new ModelData[]{var4, var7};
            var4 = new ModelData(var6, 2);
         }

         int var5;
         if(this.colourToReplace != null) {
            for(var5 = 0; var5 < this.colourToReplace.length; ++var5) {
               var4.method1526(this.colourToReplace[var5], this.colourToReplaceWith[var5]);
            }
         }

         if(this.textureToReplace != null) {
            for(var5 = 0; var5 < this.textureToReplace.length; ++var5) {
               var4.method1564(this.textureToReplace[var5], this.textToReplaceWith[var5]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-381474250"
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

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(ZB)LModelData;",
      garbageValue = "-28"
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
         ModelData var5 = ModelData.method1559(field2961, var2, 0);
         if(var3 != -1) {
            ModelData var9 = ModelData.method1559(field2961, var3, 0);
            if(var4 != -1) {
               ModelData var7 = ModelData.method1559(field2961, var4, 0);
               ModelData[] var8 = new ModelData[]{var5, var9, var7};
               var5 = new ModelData(var8, 3);
            } else {
               ModelData[] var10 = new ModelData[]{var5, var9};
               var5 = new ModelData(var10, 2);
            }
         }

         if(!var1 && this.maleOffset != 0) {
            var5.method1561(0, this.maleOffset, 0);
         }

         if(var1 && this.femaleOffset != 0) {
            var5.method1561(0, this.femaleOffset, 0);
         }

         int var6;
         if(null != this.colourToReplace) {
            for(var6 = 0; var6 < this.colourToReplace.length; ++var6) {
               var5.method1526(this.colourToReplace[var6], this.colourToReplaceWith[var6]);
            }
         }

         if(this.textureToReplace != null) {
            for(var6 = 0; var6 < this.textureToReplace.length; ++var6) {
               var5.method1564(this.textureToReplace[var6], this.textToReplaceWith[var6]);
            }
         }

         return var5;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IB)LModelData;",
      garbageValue = "-40"
   )
   public final ModelData method3713(int var1) {
      int var3;
      if(null != this.countObj && var1 > 1) {
         int var2 = -1;

         for(var3 = 0; var3 < 10; ++var3) {
            if(var1 >= this.countCo[var3] && this.countCo[var3] != 0) {
               var2 = this.countObj[var3];
            }
         }

         if(var2 != -1) {
            return class103.getItemDefinition(var2).method3713(1);
         }
      }

      ModelData var4 = ModelData.method1559(field2961, this.inventoryModel, 0);
      if(var4 == null) {
         return null;
      } else {
         if(this.resizeX != 128 || this.resizeY != 128 || this.resizeZ != 128) {
            var4.method1529(this.resizeX, this.resizeY, this.resizeZ);
         }

         if(null != this.colourToReplace) {
            for(var3 = 0; var3 < this.colourToReplace.length; ++var3) {
               var4.method1526(this.colourToReplace[var3], this.colourToReplaceWith[var3]);
            }
         }

         if(null != this.textureToReplace) {
            for(var3 = 0; var3 < this.textureToReplace.length; ++var3) {
               var4.method1564(this.textureToReplace[var3], this.textToReplaceWith[var3]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LItemComposition;LItemComposition;B)V",
      garbageValue = "-11"
   )
   void method3716(ItemComposition var1, ItemComposition var2) {
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

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "110"
   )
   public static void method3718(int var0, int var1) {
      Varbit var2 = class164.method3157(var0);
      int var3 = var2.leastSignificantBit;
      int var4 = var2.configId;
      int var5 = var2.mostSignificantBit;
      int var6 = class165.field2165[var5 - var4];
      if(var1 < 0 || var1 > var6) {
         var1 = 0;
      }

      var6 <<= var4;
      class165.widgetSettings[var3] = class165.widgetSettings[var3] & ~var6 | var1 << var4 & var6;
   }
}
