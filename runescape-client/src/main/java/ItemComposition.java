import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ii")
@Implements("ItemComposition")
public class ItemComposition extends CacheableNode {
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lgo;"
   )
   @Export("items")
   static NodeCache items;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lgo;"
   )
   @Export("itemModelCache")
   static NodeCache itemModelCache;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   static IndexDataBase field3491;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lip;"
   )
   @Export("item_ref")
   static IndexDataBase item_ref;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lgo;"
   )
   @Export("itemSpriteCache")
   public static NodeCache itemSpriteCache;
   @ObfuscatedName("e")
   @Export("isMembersWorld")
   public static boolean isMembersWorld;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -1551582311
   )
   @Export("maleHeadModel")
   int maleHeadModel;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -359979371
   )
   @Export("maleModel")
   int maleModel;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 924681177
   )
   @Export("inventoryModel")
   int inventoryModel;
   @ObfuscatedName("ak")
   @Export("countObj")
   int[] countObj;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 490007761
   )
   @Export("team")
   int team;
   @ObfuscatedName("bw")
   @ObfuscatedSignature(
      signature = "Lgk;"
   )
   IterableHashTable field3510;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 866341417
   )
   @Export("maleHeadModel2")
   int maleHeadModel2;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -1247178789
   )
   @Export("maleModel1")
   int maleModel1;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -1293889917
   )
   @Export("maleModel2")
   int maleModel2;
   @ObfuscatedName("aw")
   @Export("inventoryActions")
   public String[] inventoryActions;
   @ObfuscatedName("i")
   @Export("name")
   public String name;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -1646898671
   )
   @Export("femaleHeadModel")
   int femaleHeadModel;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 496783083
   )
   @Export("zoom2d")
   public int zoom2d;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1458897017
   )
   @Export("id")
   public int id;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 676781547
   )
   @Export("femaleHeadModel2")
   int femaleHeadModel2;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 1343656771
   )
   @Export("femaleModel")
   int femaleModel;
   @ObfuscatedName("ar")
   @Export("countCo")
   int[] countCo;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -495286441
   )
   @Export("femaleModel1")
   int femaleModel1;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 2118137943
   )
   @Export("femaleModel2")
   int femaleModel2;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1271542317
   )
   @Export("xan2d")
   public int xan2d;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 1071227553
   )
   @Export("resizeX")
   int resizeX;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1066532391
   )
   @Export("yan2d")
   public int yan2d;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1120774179
   )
   @Export("offsetX2d")
   public int offsetX2d;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 178128053
   )
   @Export("isStackable")
   public int isStackable;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -179174641
   )
   @Export("resizeY")
   int resizeY;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -288717149
   )
   @Export("offsetY2d")
   public int offsetY2d;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1696638053
   )
   @Export("zan2d")
   public int zan2d;
   @ObfuscatedName("aa")
   @Export("isMembers")
   public boolean isMembers;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -1138524173
   )
   @Export("resizeZ")
   int resizeZ;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -1341230381
   )
   @Export("price")
   public int price;
   @ObfuscatedName("h")
   @Export("colourToReplace")
   short[] colourToReplace;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -915907621
   )
   @Export("maleOffset")
   int maleOffset;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 1284889599
   )
   @Export("notedTemplate")
   public int notedTemplate;
   @ObfuscatedName("ay")
   @Export("groundActions")
   public String[] groundActions;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -151156467
   )
   @Export("femaleOffset")
   int femaleOffset;
   @ObfuscatedName("bs")
   public boolean field3526;
   @ObfuscatedName("j")
   @Export("textureToReplace")
   short[] textureToReplace;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = -412868723
   )
   @Export("ambient")
   public int ambient;
   @ObfuscatedName("b")
   @Export("colourToReplaceWith")
   short[] colourToReplaceWith;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = -410140935
   )
   @Export("notedId")
   int notedId;
   @ObfuscatedName("y")
   @Export("textToReplaceWith")
   short[] textToReplaceWith;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = -252792731
   )
   @Export("contrast")
   public int contrast;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -1342621145
   )
   @Export("note")
   public int note;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = 35676399
   )
   @Export("unnotedId")
   int unnotedId;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = -56832475
   )
   public int field3537;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = -361278531
   )
   public int field3543;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = -59628907
   )
   public int field3528;

   static {
      items = new NodeCache(64);
      itemModelCache = new NodeCache(50);
      itemSpriteCache = new NodeCache(200);
   }

   ItemComposition() {
      this.name = "null";
      this.zoom2d = 2000;
      this.xan2d = 0;
      this.yan2d = 0;
      this.zan2d = 0;
      this.offsetX2d = 0;
      this.offsetY2d = 0;
      this.isStackable = 0;
      this.price = 1;
      this.isMembers = false;
      this.groundActions = new String[]{null, null, "Take", null, null};
      this.inventoryActions = new String[]{null, null, null, null, "Drop"};
      this.team = -2;
      this.maleModel = -1;
      this.maleModel1 = -1;
      this.maleOffset = 0;
      this.femaleModel = -1;
      this.femaleModel1 = -1;
      this.femaleOffset = 0;
      this.maleModel2 = -1;
      this.femaleModel2 = -1;
      this.maleHeadModel = -1;
      this.maleHeadModel2 = -1;
      this.femaleHeadModel = -1;
      this.femaleHeadModel2 = -1;
      this.note = -1;
      this.notedTemplate = -1;
      this.resizeX = 128;
      this.resizeY = 128;
      this.resizeZ = 128;
      this.ambient = 0;
      this.contrast = 0;
      this.field3537 = 0;
      this.field3526 = false;
      this.unnotedId = -1;
      this.notedId = -1;
      this.field3528 = -1;
      this.field3543 = -1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lfz;IB)V",
      garbageValue = "-16"
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
            this.field3526 = true;
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
            this.field3537 = var1.readUnsignedByte();
         } else if(var2 == 139) {
            this.unnotedId = var1.readUnsignedShort();
         } else if(var2 == 140) {
            this.notedId = var1.readUnsignedShort();
         } else if(var2 == 148) {
            this.field3528 = var1.readUnsignedShort();
         } else if(var2 == 149) {
            this.field3543 = var1.readUnsignedShort();
         } else if(var2 == 249) {
            this.field3510 = FileOnDisk.method2427(var1, this.field3510);
         }
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)Leh;",
      garbageValue = "1804508472"
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
            return FaceNormal.getItemDefinition(var2).getModel(1);
         }
      }

      Model var5 = (Model)itemModelCache.get((long)this.id);
      if(var5 != null) {
         return var5;
      } else {
         ModelData var6 = ModelData.method2534(field3491, this.inventoryModel, 0);
         if(var6 == null) {
            return null;
         } else {
            if(this.resizeX != 128 || this.resizeY != 128 || this.resizeZ != 128) {
               var6.method2470(this.resizeX, this.resizeY, this.resizeZ);
            }

            int var4;
            if(this.colourToReplace != null) {
               for(var4 = 0; var4 < this.colourToReplace.length; ++var4) {
                  var6.recolor(this.colourToReplace[var4], this.colourToReplaceWith[var4]);
               }
            }

            if(this.textureToReplace != null) {
               for(var4 = 0; var4 < this.textureToReplace.length; ++var4) {
                  var6.method2495(this.textureToReplace[var4], this.textToReplaceWith[var4]);
               }
            }

            var5 = var6.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
            var5.field1936 = true;
            itemModelCache.put(var5, (long)this.id);
            return var5;
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IS)Ldo;",
      garbageValue = "14205"
   )
   public final ModelData method4661(int var1) {
      int var3;
      if(this.countObj != null && var1 > 1) {
         int var2 = -1;

         for(var3 = 0; var3 < 10; ++var3) {
            if(var1 >= this.countCo[var3] && this.countCo[var3] != 0) {
               var2 = this.countObj[var3];
            }
         }

         if(var2 != -1) {
            return FaceNormal.getItemDefinition(var2).method4661(1);
         }
      }

      ModelData var4 = ModelData.method2534(field3491, this.inventoryModel, 0);
      if(var4 == null) {
         return null;
      } else {
         if(this.resizeX != 128 || this.resizeY != 128 || this.resizeZ != 128) {
            var4.method2470(this.resizeX, this.resizeY, this.resizeZ);
         }

         if(this.colourToReplace != null) {
            for(var3 = 0; var3 < this.colourToReplace.length; ++var3) {
               var4.recolor(this.colourToReplace[var3], this.colourToReplaceWith[var3]);
            }
         }

         if(this.textureToReplace != null) {
            for(var3 = 0; var3 < this.textureToReplace.length; ++var3) {
               var4.method2495(this.textureToReplace[var3], this.textToReplaceWith[var3]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1498463627"
   )
   @Export("post")
   void post() {
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(ZB)Z",
      garbageValue = "52"
   )
   public final boolean method4664(boolean var1) {
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
         if(!field3491.method4192(var2, 0)) {
            var4 = false;
         }

         if(var3 != -1 && !field3491.method4192(var3, 0)) {
            var4 = false;
         }

         return var4;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lfz;I)V",
      garbageValue = "-2079368096"
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
      signature = "(ZI)Ldo;",
      garbageValue = "-149479058"
   )
   public final ModelData method4677(boolean var1) {
      int var2 = this.maleHeadModel;
      int var3 = this.maleHeadModel2;
      if(var1) {
         var2 = this.femaleHeadModel;
         var3 = this.femaleHeadModel2;
      }

      if(var2 == -1) {
         return null;
      } else {
         ModelData var4 = ModelData.method2534(field3491, var2, 0);
         if(var3 != -1) {
            ModelData var5 = ModelData.method2534(field3491, var3, 0);
            ModelData[] var6 = new ModelData[]{var4, var5};
            var4 = new ModelData(var6, 2);
         }

         int var7;
         if(this.colourToReplace != null) {
            for(var7 = 0; var7 < this.colourToReplace.length; ++var7) {
               var4.recolor(this.colourToReplace[var7], this.colourToReplaceWith[var7]);
            }
         }

         if(this.textureToReplace != null) {
            for(var7 = 0; var7 < this.textureToReplace.length; ++var7) {
               var4.method2495(this.textureToReplace[var7], this.textToReplaceWith[var7]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(ZI)Z",
      garbageValue = "-1764937417"
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
         if(!field3491.method4192(var2, 0)) {
            var5 = false;
         }

         if(var3 != -1 && !field3491.method4192(var3, 0)) {
            var5 = false;
         }

         if(var4 != -1 && !field3491.method4192(var4, 0)) {
            var5 = false;
         }

         return var5;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(ZI)Ldo;",
      garbageValue = "-1896556242"
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
         ModelData var5 = ModelData.method2534(field3491, var2, 0);
         if(var3 != -1) {
            ModelData var6 = ModelData.method2534(field3491, var3, 0);
            if(var4 != -1) {
               ModelData var7 = ModelData.method2534(field3491, var4, 0);
               ModelData[] var8 = new ModelData[]{var5, var6, var7};
               var5 = new ModelData(var8, 3);
            } else {
               ModelData[] var10 = new ModelData[]{var5, var6};
               var5 = new ModelData(var10, 2);
            }
         }

         if(!var1 && this.maleOffset != 0) {
            var5.method2463(0, this.maleOffset, 0);
         }

         if(var1 && this.femaleOffset != 0) {
            var5.method2463(0, this.femaleOffset, 0);
         }

         int var9;
         if(this.colourToReplace != null) {
            for(var9 = 0; var9 < this.colourToReplace.length; ++var9) {
               var5.recolor(this.colourToReplace[var9], this.colourToReplaceWith[var9]);
            }
         }

         if(this.textureToReplace != null) {
            for(var9 = 0; var9 < this.textureToReplace.length; ++var9) {
               var5.method2495(this.textureToReplace[var9], this.textToReplaceWith[var9]);
            }
         }

         return var5;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lii;Lii;B)V",
      garbageValue = "0"
   )
   void method4658(ItemComposition var1, ItemComposition var2) {
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

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lii;Lii;I)V",
      garbageValue = "496040517"
   )
   void method4695(ItemComposition var1, ItemComposition var2) {
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
      this.field3537 = var2.field3537;
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

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lii;Lii;B)V",
      garbageValue = "-50"
   )
   void method4704(ItemComposition var1, ItemComposition var2) {
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
      this.field3526 = false;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(IB)Lii;",
      garbageValue = "8"
   )
   public ItemComposition method4662(int var1) {
      if(this.countObj != null && var1 > 1) {
         int var2 = -1;

         for(int var3 = 0; var3 < 10; ++var3) {
            if(var1 >= this.countCo[var3] && this.countCo[var3] != 0) {
               var2 = this.countObj[var3];
            }
         }

         if(var2 != -1) {
            return FaceNormal.getItemDefinition(var2);
         }
      }

      return this;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1218745940"
   )
   public int method4667(int var1, int var2) {
      return class227.method4159(this.field3510, var1, var2);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-1395575605"
   )
   public String method4668(int var1, String var2) {
      return class204.method3902(this.field3510, var1, var2);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1180433876"
   )
   public int method4669() {
      return this.team != -1 && this.inventoryActions != null?(this.team >= 0?(this.inventoryActions[this.team] != null?this.team:-1):("Drop".equalsIgnoreCase(this.inventoryActions[4])?4:-1)):-1;
   }
}
