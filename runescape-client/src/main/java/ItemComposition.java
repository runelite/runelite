import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gu")
@Implements("ItemComposition")
public class ItemComposition extends CacheableNode {
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = 1836784175
   )
   @Export("contrast")
   public int contrast = 0;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -1397064887
   )
   @Export("team")
   int team = -2;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = -836183701
   )
   int field2951 = -1;
   @ObfuscatedName("w")
   public static NodeCache field2952 = new NodeCache(64);
   @ObfuscatedName("y")
   @Export("name")
   public String name = "null";
   @ObfuscatedName("s")
   @Export("itemSpriteCache")
   public static NodeCache itemSpriteCache = new NodeCache(200);
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 910811737
   )
   @Export("femaleModel1")
   int femaleModel1 = -1;
   @ObfuscatedName("ah")
   @Export("groundActions")
   public String[] groundActions = new String[]{null, null, "Take", null, null};
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 2092552455
   )
   @Export("isStackable")
   public int isStackable = 0;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = 1387805563
   )
   public int field2958 = -1;
   @ObfuscatedName("a")
   @Export("colourToReplace")
   short[] colourToReplace;
   @ObfuscatedName("v")
   @Export("colourToReplaceWith")
   short[] colourToReplaceWith;
   @ObfuscatedName("z")
   @Export("textureToReplace")
   short[] textureToReplace;
   @ObfuscatedName("x")
   @Export("textToReplaceWith")
   short[] textToReplaceWith;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = -11002557
   )
   int field2963 = -1;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -370698179
   )
   @Export("xan2d")
   public int xan2d = 0;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -86478451
   )
   @Export("yan2d")
   public int yan2d = 0;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -766543741
   )
   @Export("zan2d")
   public int zan2d = 0;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 2096477263
   )
   @Export("offsetX2d")
   public int offsetX2d = 0;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 2107901305
   )
   @Export("offsetY2d")
   public int offsetY2d = 0;
   @ObfuscatedName("ag")
   @Export("inventoryActions")
   public String[] inventoryActions = new String[]{null, null, null, null, "Drop"};
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -86316011
   )
   @Export("price")
   public int price = 1;
   @ObfuscatedName("aq")
   @Export("isMembers")
   public boolean isMembers = false;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 229975517
   )
   @Export("id")
   public int id;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1451209085
   )
   @Export("inventoryModel")
   int inventoryModel;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -1678349399
   )
   @Export("maleModel")
   int maleModel = -1;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 1846221789
   )
   @Export("maleModel1")
   int maleModel1 = -1;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -811974535
   )
   @Export("maleOffset")
   int maleOffset = 0;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 651109629
   )
   @Export("zoom2d")
   public int zoom2d = 2000;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 1725726859
   )
   @Export("resizeX")
   int resizeX = 128;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 387882791
   )
   @Export("femaleOffset")
   int femaleOffset = 0;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -2139948019
   )
   @Export("femaleModel")
   int femaleModel = -1;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 1981620457
   )
   @Export("femaleModel2")
   int femaleModel2 = -1;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -500315119
   )
   @Export("maleHeadModel")
   int maleHeadModel = -1;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -1276711173
   )
   @Export("maleHeadModel2")
   int maleHeadModel2 = -1;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 1400238753
   )
   @Export("femaleHeadModel")
   int femaleHeadModel = -1;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 380652753
   )
   @Export("femaleHeadModel2")
   int femaleHeadModel2 = -1;
   @ObfuscatedName("aa")
   @Export("countObj")
   int[] countObj;
   @ObfuscatedName("as")
   @Export("countCo")
   int[] countCo;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -1596080141
   )
   @Export("note")
   public int note = -1;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -282525063
   )
   @Export("notedTemplate")
   public int notedTemplate = -1;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -821904359
   )
   @Export("resizeZ")
   int resizeZ = 128;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -1644380203
   )
   @Export("resizeY")
   int resizeY = 128;
   @ObfuscatedName("q")
   public static Font field2993;
   @ObfuscatedName("j")
   @Export("itemModelCache")
   public static NodeCache itemModelCache = new NodeCache(50);
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -1256835791
   )
   @Export("maleModel2")
   int maleModel2 = -1;
   @ObfuscatedName("br")
   public boolean field2997 = false;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = 949425043
   )
   public int field2998 = 0;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = 1108544893
   )
   @Export("ambient")
   public int ambient = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1930954597
   )
   public static int field3000;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = -533438675
   )
   public int field3001 = -1;
   @ObfuscatedName("r")
   static int[] field3003;
   @ObfuscatedName("je")
   @ObfuscatedGetter(
      intValue = 1562891813
   )
   static int field3004;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   void method3679() {
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(LBuffer;S)V",
      garbageValue = "-20823"
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

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-1859319902"
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
            this.field2998 = var1.readUnsignedByte();
         } else if(var2 == 139) {
            this.field2963 = var1.readUnsignedShort();
         } else if(var2 == 140) {
            this.field2951 = var1.readUnsignedShort();
         } else if(var2 == 148) {
            this.field2958 = var1.readUnsignedShort();
         } else if(var2 == 149) {
            this.field3001 = var1.readUnsignedShort();
         }
      }

   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)LModel;",
      garbageValue = "1697831973"
   )
   @Export("getModel")
   public final Model getModel(int var1) {
      if(this.countObj != null && var1 > 1) {
         int var2 = -1;

         for(int var3 = 0; var3 < 10; ++var3) {
            if(var1 >= this.countCo[var3] && this.countCo[var3] != 0) {
               var2 = this.countObj[var3];
            }
         }

         if(var2 != -1) {
            return class196.getItemDefinition(var2).getModel(1);
         }
      }

      Model var5 = (Model)itemModelCache.get((long)this.id);
      if(var5 != null) {
         return var5;
      } else {
         ModelData var6 = ModelData.method1495(class47.field956, this.inventoryModel, 0);
         if(var6 == null) {
            return null;
         } else {
            if(this.resizeX != 128 || this.resizeY != 128 || this.resizeZ != 128) {
               var6.method1494(this.resizeX, this.resizeY, this.resizeZ);
            }

            int var4;
            if(this.colourToReplace != null) {
               for(var4 = 0; var4 < this.colourToReplace.length; ++var4) {
                  var6.method1509(this.colourToReplace[var4], this.colourToReplaceWith[var4]);
               }
            }

            if(this.textureToReplace != null) {
               for(var4 = 0; var4 < this.textureToReplace.length; ++var4) {
                  var6.method1510(this.textureToReplace[var4], this.textToReplaceWith[var4]);
               }
            }

            var5 = var6.method1524(this.ambient + 64, this.contrast + 768, -50, -10, -50);
            var5.field1409 = true;
            itemModelCache.put(var5, (long)this.id);
            return var5;
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)LItemComposition;",
      garbageValue = "1942378763"
   )
   public ItemComposition method3683(int var1) {
      if(this.countObj != null && var1 > 1) {
         int var2 = -1;

         for(int var3 = 0; var3 < 10; ++var3) {
            if(var1 >= this.countCo[var3] && this.countCo[var3] != 0) {
               var2 = this.countObj[var3];
            }
         }

         if(var2 != -1) {
            return class196.getItemDefinition(var2);
         }
      }

      return this;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IB)LModelData;",
      garbageValue = "45"
   )
   public final ModelData method3685(int var1) {
      int var2;
      if(this.countObj != null && var1 > 1) {
         int var3 = -1;

         for(var2 = 0; var2 < 10; ++var2) {
            if(var1 >= this.countCo[var2] && this.countCo[var2] != 0) {
               var3 = this.countObj[var2];
            }
         }

         if(var3 != -1) {
            return class196.getItemDefinition(var3).method3685(1);
         }
      }

      ModelData var4 = ModelData.method1495(class47.field956, this.inventoryModel, 0);
      if(var4 == null) {
         return null;
      } else {
         if(this.resizeX != 128 || this.resizeY != 128 || this.resizeZ != 128) {
            var4.method1494(this.resizeX, this.resizeY, this.resizeZ);
         }

         if(this.colourToReplace != null) {
            for(var2 = 0; var2 < this.colourToReplace.length; ++var2) {
               var4.method1509(this.colourToReplace[var2], this.colourToReplaceWith[var2]);
            }
         }

         if(this.textureToReplace != null) {
            for(var2 = 0; var2 < this.textureToReplace.length; ++var2) {
               var4.method1510(this.textureToReplace[var2], this.textToReplaceWith[var2]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "-8434"
   )
   public int method3687() {
      return this.team != -1 && this.inventoryActions != null?(this.team >= 0?(this.inventoryActions[this.team] != null?this.team:-1):("Drop".equalsIgnoreCase(this.inventoryActions[4])?4:-1)):-1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ZB)LModelData;",
      garbageValue = "13"
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
         ModelData var5 = ModelData.method1495(class47.field956, var2, 0);
         if(var3 != -1) {
            ModelData var6 = ModelData.method1495(class47.field956, var3, 0);
            if(var4 != -1) {
               ModelData var7 = ModelData.method1495(class47.field956, var4, 0);
               ModelData[] var8 = new ModelData[]{var5, var6, var7};
               var5 = new ModelData(var8, 3);
            } else {
               ModelData[] var10 = new ModelData[]{var5, var6};
               var5 = new ModelData(var10, 2);
            }
         }

         if(!var1 && this.maleOffset != 0) {
            var5.method1508(0, this.maleOffset, 0);
         }

         if(var1 && this.femaleOffset != 0) {
            var5.method1508(0, this.femaleOffset, 0);
         }

         int var9;
         if(this.colourToReplace != null) {
            for(var9 = 0; var9 < this.colourToReplace.length; ++var9) {
               var5.method1509(this.colourToReplace[var9], this.colourToReplaceWith[var9]);
            }
         }

         if(this.textureToReplace != null) {
            for(var9 = 0; var9 < this.textureToReplace.length; ++var9) {
               var5.method1510(this.textureToReplace[var9], this.textToReplaceWith[var9]);
            }
         }

         return var5;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(ZB)LModelData;",
      garbageValue = "4"
   )
   public final ModelData method3690(boolean var1) {
      int var2 = this.maleHeadModel;
      int var3 = this.maleHeadModel2;
      if(var1) {
         var2 = this.femaleHeadModel;
         var3 = this.femaleHeadModel2;
      }

      if(var2 == -1) {
         return null;
      } else {
         ModelData var4 = ModelData.method1495(class47.field956, var2, 0);
         if(var3 != -1) {
            ModelData var5 = ModelData.method1495(class47.field956, var3, 0);
            ModelData[] var6 = new ModelData[]{var4, var5};
            var4 = new ModelData(var6, 2);
         }

         int var7;
         if(this.colourToReplace != null) {
            for(var7 = 0; var7 < this.colourToReplace.length; ++var7) {
               var4.method1509(this.colourToReplace[var7], this.colourToReplaceWith[var7]);
            }
         }

         if(this.textureToReplace != null) {
            for(var7 = 0; var7 < this.textureToReplace.length; ++var7) {
               var4.method1510(this.textureToReplace[var7], this.textToReplaceWith[var7]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(LItemComposition;LItemComposition;I)V",
      garbageValue = "140347228"
   )
   void method3691(ItemComposition var1, ItemComposition var2) {
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
      this.field2998 = var2.field2998;
      this.groundActions = var2.groundActions;
      this.inventoryActions = new String[5];
      if(var2.inventoryActions != null) {
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
      garbageValue = "-1584158044"
   )
   void method3692(ItemComposition var1, ItemComposition var2) {
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

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LItemComposition;LItemComposition;I)V",
      garbageValue = "929521843"
   )
   void method3693(ItemComposition var1, ItemComposition var2) {
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

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ZI)Z",
      garbageValue = "-867613718"
   )
   public final boolean method3697(boolean var1) {
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
         if(!class47.field956.method3338(var2, 0)) {
            var4 = false;
         }

         if(var3 != -1 && !class47.field956.method3338(var3, 0)) {
            var4 = false;
         }

         return var4;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(ZI)Z",
      garbageValue = "430048530"
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
         if(!class47.field956.method3338(var2, 0)) {
            var5 = false;
         }

         if(var3 != -1 && !class47.field956.method3338(var3, 0)) {
            var5 = false;
         }

         if(var4 != -1 && !class47.field956.method3338(var4, 0)) {
            var5 = false;
         }

         return var5;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lclass182;Ljava/lang/String;Ljava/lang/String;I)[LModIcon;",
      garbageValue = "1264267997"
   )
   public static ModIcon[] method3719(IndexDataBase var0, String var1, String var2) {
      int var3 = var0.method3351(var1);
      int var4 = var0.method3352(var3, var2);
      return class38.method766(var0, var3, var4);
   }
}
