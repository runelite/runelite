import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ix")
@Implements("ItemComposition")
public class ItemComposition extends CacheableNode {
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lgg;"
   )
   @Export("items")
   static NodeCache items;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   static IndexDataBase field3470;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgg;"
   )
   @Export("itemModelCache")
   static NodeCache itemModelCache;
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lim;"
   )
   @Export("item_ref")
   static IndexDataBase item_ref;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgg;"
   )
   @Export("itemSpriteCache")
   public static NodeCache itemSpriteCache;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -1444155367
   )
   @Export("maleHeadModel")
   int maleHeadModel;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 307860055
   )
   @Export("maleModel")
   int maleModel;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 1988303543
   )
   @Export("inventoryModel")
   int inventoryModel;
   @ObfuscatedName("ak")
   @Export("countObj")
   int[] countObj;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 1153078891
   )
   @Export("team")
   int team;
   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   IterableHashTable field3495;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 490986829
   )
   @Export("maleHeadModel2")
   int maleHeadModel2;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 2114275291
   )
   @Export("maleModel1")
   int maleModel1;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 67698367
   )
   @Export("maleModel2")
   int maleModel2;
   @ObfuscatedName("ag")
   @Export("inventoryActions")
   public String[] inventoryActions;
   @ObfuscatedName("b")
   @Export("name")
   public String name;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -994252621
   )
   @Export("femaleHeadModel")
   int femaleHeadModel;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 129959393
   )
   @Export("zoom2d")
   public int zoom2d;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1808868407
   )
   @Export("id")
   public int id;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 1013867849
   )
   @Export("femaleHeadModel2")
   int femaleHeadModel2;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 1087551855
   )
   @Export("femaleModel")
   int femaleModel;
   @ObfuscatedName("as")
   @Export("countCo")
   int[] countCo;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 868614513
   )
   @Export("femaleModel1")
   int femaleModel1;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -2026914925
   )
   @Export("femaleModel2")
   int femaleModel2;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 1288331749
   )
   @Export("xan2d")
   public int xan2d;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -1514129025
   )
   @Export("resizeX")
   int resizeX;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -137373847
   )
   @Export("yan2d")
   public int yan2d;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1709233511
   )
   @Export("offsetX2d")
   public int offsetX2d;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 2006893319
   )
   @Export("isStackable")
   public int isStackable;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 611608849
   )
   @Export("resizeY")
   int resizeY;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1642465705
   )
   @Export("offsetY2d")
   public int offsetY2d;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -597938625
   )
   @Export("zan2d")
   public int zan2d;
   @ObfuscatedName("ax")
   @Export("isMembers")
   public boolean isMembers;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 2057081153
   )
   @Export("price")
   public int price;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 1596306005
   )
   @Export("resizeZ")
   int resizeZ;
   @ObfuscatedName("w")
   @Export("colourToReplace")
   short[] colourToReplace;
   @ObfuscatedName("n")
   @Export("textureToReplace")
   short[] textureToReplace;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 725275695
   )
   @Export("maleOffset")
   int maleOffset;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 680442059
   )
   @Export("notedTemplate")
   public int notedTemplate;
   @ObfuscatedName("at")
   @Export("groundActions")
   public String[] groundActions;
   @ObfuscatedName("k")
   @Export("colourToReplaceWith")
   short[] colourToReplaceWith;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -986723681
   )
   @Export("femaleOffset")
   int femaleOffset;
   @ObfuscatedName("c")
   @Export("textToReplaceWith")
   short[] textToReplaceWith;
   @ObfuscatedName("bs")
   public boolean field3516;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = -114482247
   )
   @Export("ambient")
   public int ambient;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = -1318269901
   )
   @Export("notedId")
   int notedId;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = -1262276449
   )
   @Export("contrast")
   public int contrast;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 282901103
   )
   @Export("note")
   public int note;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = -1553289677
   )
   public int field3515;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = 768900089
   )
   public int field3520;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = 2044078165
   )
   @Export("unnotedId")
   int unnotedId;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = -1514378177
   )
   public int field3519;

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
      this.field3515 = 0;
      this.field3516 = false;
      this.unnotedId = -1;
      this.notedId = -1;
      this.field3519 = -1;
      this.field3520 = -1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lfw;II)V",
      garbageValue = "2029603762"
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
            this.field3516 = true;
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
            this.field3515 = var1.readUnsignedByte();
         } else if(var2 == 139) {
            this.unnotedId = var1.readUnsignedShort();
         } else if(var2 == 140) {
            this.notedId = var1.readUnsignedShort();
         } else if(var2 == 148) {
            this.field3519 = var1.readUnsignedShort();
         } else if(var2 == 149) {
            this.field3520 = var1.readUnsignedShort();
         } else if(var2 == 249) {
            this.field3495 = FrameMap.method2698(var1, this.field3495);
         }
      }

   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IS)Lev;",
      garbageValue = "8320"
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
            return Friend.getItemDefinition(var2).getModel(1);
         }
      }

      Model var5 = (Model)itemModelCache.get((long)this.id);
      if(var5 != null) {
         return var5;
      } else {
         ModelData var6 = ModelData.method2477(field3470, this.inventoryModel, 0);
         if(var6 == null) {
            return null;
         } else {
            if(this.resizeX != 128 || this.resizeY != 128 || this.resizeZ != 128) {
               var6.method2431(this.resizeX, this.resizeY, this.resizeZ);
            }

            int var4;
            if(this.colourToReplace != null) {
               for(var4 = 0; var4 < this.colourToReplace.length; ++var4) {
                  var6.recolor(this.colourToReplace[var4], this.colourToReplaceWith[var4]);
               }
            }

            if(this.textureToReplace != null) {
               for(var4 = 0; var4 < this.textureToReplace.length; ++var4) {
                  var6.method2429(this.textureToReplace[var4], this.textToReplaceWith[var4]);
               }
            }

            var5 = var6.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
            var5.field1902 = true;
            itemModelCache.put(var5, (long)this.id);
            return var5;
         }
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)Ldk;",
      garbageValue = "750174672"
   )
   public final ModelData method4544(int var1) {
      int var3;
      if(this.countObj != null && var1 > 1) {
         int var2 = -1;

         for(var3 = 0; var3 < 10; ++var3) {
            if(var1 >= this.countCo[var3] && this.countCo[var3] != 0) {
               var2 = this.countObj[var3];
            }
         }

         if(var2 != -1) {
            return Friend.getItemDefinition(var2).method4544(1);
         }
      }

      ModelData var4 = ModelData.method2477(field3470, this.inventoryModel, 0);
      if(var4 == null) {
         return null;
      } else {
         if(this.resizeX != 128 || this.resizeY != 128 || this.resizeZ != 128) {
            var4.method2431(this.resizeX, this.resizeY, this.resizeZ);
         }

         if(this.colourToReplace != null) {
            for(var3 = 0; var3 < this.colourToReplace.length; ++var3) {
               var4.recolor(this.colourToReplace[var3], this.colourToReplaceWith[var3]);
            }
         }

         if(this.textureToReplace != null) {
            for(var3 = 0; var3 < this.textureToReplace.length; ++var3) {
               var4.method2429(this.textureToReplace[var3], this.textToReplaceWith[var3]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(ZB)Z",
      garbageValue = "-63"
   )
   public final boolean method4549(boolean var1) {
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
         if(!field3470.method4115(var2, 0)) {
            var4 = false;
         }

         if(var3 != -1 && !field3470.method4115(var3, 0)) {
            var4 = false;
         }

         return var4;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-59"
   )
   @Export("post")
   void post() {
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ZI)Ldk;",
      garbageValue = "-1385208138"
   )
   public final ModelData method4550(boolean var1) {
      int var2 = this.maleHeadModel;
      int var3 = this.maleHeadModel2;
      if(var1) {
         var2 = this.femaleHeadModel;
         var3 = this.femaleHeadModel2;
      }

      if(var2 == -1) {
         return null;
      } else {
         ModelData var4 = ModelData.method2477(field3470, var2, 0);
         if(var3 != -1) {
            ModelData var5 = ModelData.method2477(field3470, var3, 0);
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
               var4.method2429(this.textureToReplace[var7], this.textToReplaceWith[var7]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lfw;B)V",
      garbageValue = "31"
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

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ZB)Z",
      garbageValue = "-76"
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
         if(!field3470.method4115(var2, 0)) {
            var5 = false;
         }

         if(var3 != -1 && !field3470.method4115(var3, 0)) {
            var5 = false;
         }

         if(var4 != -1 && !field3470.method4115(var4, 0)) {
            var5 = false;
         }

         return var5;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(ZB)Ldk;",
      garbageValue = "1"
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
         ModelData var5 = ModelData.method2477(field3470, var2, 0);
         if(var3 != -1) {
            ModelData var6 = ModelData.method2477(field3470, var3, 0);
            if(var4 != -1) {
               ModelData var7 = ModelData.method2477(field3470, var4, 0);
               ModelData[] var8 = new ModelData[]{var5, var6, var7};
               var5 = new ModelData(var8, 3);
            } else {
               ModelData[] var10 = new ModelData[]{var5, var6};
               var5 = new ModelData(var10, 2);
            }
         }

         if(!var1 && this.maleOffset != 0) {
            var5.method2427(0, this.maleOffset, 0);
         }

         if(var1 && this.femaleOffset != 0) {
            var5.method2427(0, this.femaleOffset, 0);
         }

         int var9;
         if(this.colourToReplace != null) {
            for(var9 = 0; var9 < this.colourToReplace.length; ++var9) {
               var5.recolor(this.colourToReplace[var9], this.colourToReplaceWith[var9]);
            }
         }

         if(this.textureToReplace != null) {
            for(var9 = 0; var9 < this.textureToReplace.length; ++var9) {
               var5.method2429(this.textureToReplace[var9], this.textToReplaceWith[var9]);
            }
         }

         return var5;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Lix;Lix;I)V",
      garbageValue = "-625448085"
   )
   void method4556(ItemComposition var1, ItemComposition var2) {
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

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lix;Lix;B)V",
      garbageValue = "1"
   )
   void method4542(ItemComposition var1, ItemComposition var2) {
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
      this.field3515 = var2.field3515;
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

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Lix;Lix;I)V",
      garbageValue = "-1734616193"
   )
   void method4543(ItemComposition var1, ItemComposition var2) {
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
      this.field3516 = false;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)Lix;",
      garbageValue = "-1453703645"
   )
   public ItemComposition method4571(int var1) {
      if(this.countObj != null && var1 > 1) {
         int var2 = -1;

         for(int var3 = 0; var3 < 10; ++var3) {
            if(var1 >= this.countCo[var3] && this.countCo[var3] != 0) {
               var2 = this.countObj[var3];
            }
         }

         if(var2 != -1) {
            return Friend.getItemDefinition(var2);
         }
      }

      return this;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "16256"
   )
   public int method4595() {
      return this.team != -1 && this.inventoryActions != null?(this.team >= 0?(this.inventoryActions[this.team] != null?this.team:-1):("Drop".equalsIgnoreCase(this.inventoryActions[4])?4:-1)):-1;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "-104"
   )
   public int method4551(int var1, int var2) {
      return class56.method835(this.field3495, var1, var2);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "921485404"
   )
   public String method4552(int var1, String var2) {
      return class33.method356(this.field3495, var1, var2);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;S)Ljava/lang/String;",
      garbageValue = "181"
   )
   public static String method4612(CharSequence var0) {
      String var1 = GraphicsObject.method1686(class266.method4858(var0));
      if(var1 == null) {
         var1 = "";
      }

      return var1;
   }
}
