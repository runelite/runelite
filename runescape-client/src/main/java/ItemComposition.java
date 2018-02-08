import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jc")
@Implements("ItemComposition")
public class ItemComposition extends CacheableNode {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   @Export("item_ref")
   public static IndexDataBase item_ref;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   @Export("items")
   static NodeCache items;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   @Export("itemModelCache")
   static NodeCache itemModelCache;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   @Export("itemSpriteCache")
   public static NodeCache itemSpriteCache;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -152981433
   )
   @Export("id")
   public int id;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -969837987
   )
   @Export("inventoryModel")
   int inventoryModel;
   @ObfuscatedName("r")
   @Export("name")
   public String name;
   @ObfuscatedName("x")
   @Export("colourToReplace")
   short[] colourToReplace;
   @ObfuscatedName("u")
   @Export("colourToReplaceWith")
   short[] colourToReplaceWith;
   @ObfuscatedName("b")
   @Export("textureToReplace")
   short[] textureToReplace;
   @ObfuscatedName("p")
   @Export("textToReplaceWith")
   short[] textToReplaceWith;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1347194185
   )
   @Export("zoom2d")
   public int zoom2d;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 2110988685
   )
   @Export("xan2d")
   public int xan2d;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -2140289077
   )
   @Export("yan2d")
   public int yan2d;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -95594897
   )
   @Export("zan2d")
   public int zan2d;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1371642549
   )
   @Export("offsetX2d")
   public int offsetX2d;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 383286489
   )
   @Export("offsetY2d")
   public int offsetY2d;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -1056527357
   )
   @Export("isStackable")
   public int isStackable;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 742404123
   )
   @Export("price")
   public int price;
   @ObfuscatedName("aq")
   @Export("isMembers")
   public boolean isMembers;
   @ObfuscatedName("ar")
   @Export("groundActions")
   public String[] groundActions;
   @ObfuscatedName("an")
   @Export("inventoryActions")
   public String[] inventoryActions;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 223556833
   )
   @Export("team")
   int team;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -1827737103
   )
   @Export("maleModel")
   int maleModel;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -790350083
   )
   @Export("maleModel1")
   int maleModel1;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 1429151817
   )
   @Export("maleOffset")
   int maleOffset;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 1698716029
   )
   @Export("femaleModel")
   int femaleModel;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 1215907653
   )
   @Export("femaleModel1")
   int femaleModel1;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 258658451
   )
   @Export("femaleOffset")
   int femaleOffset;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -554877789
   )
   @Export("maleModel2")
   int maleModel2;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 1653253249
   )
   @Export("femaleModel2")
   int femaleModel2;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 103480299
   )
   @Export("maleHeadModel")
   int maleHeadModel;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -1224529649
   )
   @Export("maleHeadModel2")
   int maleHeadModel2;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -638230845
   )
   @Export("femaleHeadModel")
   int femaleHeadModel;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 85308499
   )
   @Export("femaleHeadModel2")
   int femaleHeadModel2;
   @ObfuscatedName("aj")
   @Export("countObj")
   int[] countObj;
   @ObfuscatedName("ap")
   @Export("countCo")
   int[] countCo;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 1796602405
   )
   @Export("note")
   public int note;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -71054063
   )
   @Export("notedTemplate")
   public int notedTemplate;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -1031408967
   )
   @Export("resizeX")
   int resizeX;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 372794353
   )
   @Export("resizeY")
   int resizeY;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -536090285
   )
   @Export("resizeZ")
   int resizeZ;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = -1460539319
   )
   @Export("ambient")
   public int ambient;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = -1336930991
   )
   @Export("contrast")
   public int contrast;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = 83023809
   )
   @Export("int1")
   public int int1;
   @ObfuscatedName("bm")
   @ObfuscatedSignature(
      signature = "Lgz;"
   )
   IterableHashTable field3615;
   @ObfuscatedName("bf")
   @Export("isTradable")
   public boolean isTradable;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = -509317287
   )
   @Export("unnotedId")
   int unnotedId;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = 1050373231
   )
   @Export("notedId")
   int notedId;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = 1143353813
   )
   @Export("int2")
   public int int2;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = -1637671765
   )
   @Export("int3")
   public int int3;

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
      this.int1 = 0;
      this.isTradable = false;
      this.unnotedId = -1;
      this.notedId = -1;
      this.int2 = -1;
      this.int3 = -1;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1476219796"
   )
   @Export("post")
   void post() {
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lgy;B)V",
      garbageValue = "-91"
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

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Lgy;II)V",
      garbageValue = "825220116"
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
            this.isTradable = true;
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
            this.int1 = var1.readUnsignedByte();
         } else if(var2 == 139) {
            this.unnotedId = var1.readUnsignedShort();
         } else if(var2 == 140) {
            this.notedId = var1.readUnsignedShort();
         } else if(var2 == 148) {
            this.int2 = var1.readUnsignedShort();
         } else if(var2 == 149) {
            this.int3 = var1.readUnsignedShort();
         } else if(var2 == 249) {
            this.field3615 = class255.readStringIntParameters(var1, this.field3615);
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Ljc;Ljc;I)V",
      garbageValue = "-1338273857"
   )
   void method4969(ItemComposition var1, ItemComposition var2) {
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

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Ljc;Ljc;B)V",
      garbageValue = "1"
   )
   void method4999(ItemComposition var1, ItemComposition var2) {
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
      this.int1 = var2.int1;
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
      signature = "(Ljc;Ljc;B)V",
      garbageValue = "110"
   )
   void method4971(ItemComposition var1, ItemComposition var2) {
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
      this.isTradable = false;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(IB)Ldw;",
      garbageValue = "16"
   )
   public final ModelData method4993(int var1) {
      int var3;
      if(this.countObj != null && var1 > 1) {
         int var2 = -1;

         for(var3 = 0; var3 < 10; ++var3) {
            if(var1 >= this.countCo[var3] && this.countCo[var3] != 0) {
               var2 = this.countObj[var3];
            }
         }

         if(var2 != -1) {
            return ItemContainer.getItemDefinition(var2).method4993(1);
         }
      }

      ModelData var4 = ModelData.method2620(class150.ItemDefinition_modelIndexCache, this.inventoryModel, 0);
      if(var4 == null) {
         return null;
      } else {
         if(this.resizeX != 128 || this.resizeY != 128 || this.resizeZ != 128) {
            var4.method2622(this.resizeX, this.resizeY, this.resizeZ);
         }

         if(this.colourToReplace != null) {
            for(var3 = 0; var3 < this.colourToReplace.length; ++var3) {
               var4.recolor(this.colourToReplace[var3], this.colourToReplaceWith[var3]);
            }
         }

         if(this.textureToReplace != null) {
            for(var3 = 0; var3 < this.textureToReplace.length; ++var3) {
               var4.method2635(this.textureToReplace[var3], this.textToReplaceWith[var3]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)Les;",
      garbageValue = "1769132485"
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
            return ItemContainer.getItemDefinition(var2).getModel(1);
         }
      }

      Model var5 = (Model)itemModelCache.get((long)this.id);
      if(var5 != null) {
         return var5;
      } else {
         ModelData var6 = ModelData.method2620(class150.ItemDefinition_modelIndexCache, this.inventoryModel, 0);
         if(var6 == null) {
            return null;
         } else {
            if(this.resizeX != 128 || this.resizeY != 128 || this.resizeZ != 128) {
               var6.method2622(this.resizeX, this.resizeY, this.resizeZ);
            }

            int var4;
            if(this.colourToReplace != null) {
               for(var4 = 0; var4 < this.colourToReplace.length; ++var4) {
                  var6.recolor(this.colourToReplace[var4], this.colourToReplaceWith[var4]);
               }
            }

            if(this.textureToReplace != null) {
               for(var4 = 0; var4 < this.textureToReplace.length; ++var4) {
                  var6.method2635(this.textureToReplace[var4], this.textToReplaceWith[var4]);
               }
            }

            var5 = var6.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
            var5.field1869 = true;
            itemModelCache.put(var5, (long)this.id);
            return var5;
         }
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IS)Ljc;",
      garbageValue = "15461"
   )
   public ItemComposition method4972(int var1) {
      if(this.countObj != null && var1 > 1) {
         int var2 = -1;

         for(int var3 = 0; var3 < 10; ++var3) {
            if(var1 >= this.countCo[var3] && this.countCo[var3] != 0) {
               var2 = this.countObj[var3];
            }
         }

         if(var2 != -1) {
            return ItemContainer.getItemDefinition(var2);
         }
      }

      return this;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(ZI)Z",
      garbageValue = "-852659125"
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
         if(!class150.ItemDefinition_modelIndexCache.tryLoadRecord(var2, 0)) {
            var5 = false;
         }

         if(var3 != -1 && !class150.ItemDefinition_modelIndexCache.tryLoadRecord(var3, 0)) {
            var5 = false;
         }

         if(var4 != -1 && !class150.ItemDefinition_modelIndexCache.tryLoadRecord(var4, 0)) {
            var5 = false;
         }

         return var5;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(ZB)Ldw;",
      garbageValue = "-90"
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
         ModelData var5 = ModelData.method2620(class150.ItemDefinition_modelIndexCache, var2, 0);
         if(var3 != -1) {
            ModelData var6 = ModelData.method2620(class150.ItemDefinition_modelIndexCache, var3, 0);
            if(var4 != -1) {
               ModelData var7 = ModelData.method2620(class150.ItemDefinition_modelIndexCache, var4, 0);
               ModelData[] var8 = new ModelData[]{var5, var6, var7};
               var5 = new ModelData(var8, 3);
            } else {
               ModelData[] var10 = new ModelData[]{var5, var6};
               var5 = new ModelData(var10, 2);
            }
         }

         if(!var1 && this.maleOffset != 0) {
            var5.method2633(0, this.maleOffset, 0);
         }

         if(var1 && this.femaleOffset != 0) {
            var5.method2633(0, this.femaleOffset, 0);
         }

         int var9;
         if(this.colourToReplace != null) {
            for(var9 = 0; var9 < this.colourToReplace.length; ++var9) {
               var5.recolor(this.colourToReplace[var9], this.colourToReplaceWith[var9]);
            }
         }

         if(this.textureToReplace != null) {
            for(var9 = 0; var9 < this.textureToReplace.length; ++var9) {
               var5.method2635(this.textureToReplace[var9], this.textToReplaceWith[var9]);
            }
         }

         return var5;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(ZB)Z",
      garbageValue = "5"
   )
   public final boolean method4978(boolean var1) {
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
         if(!class150.ItemDefinition_modelIndexCache.tryLoadRecord(var2, 0)) {
            var4 = false;
         }

         if(var3 != -1 && !class150.ItemDefinition_modelIndexCache.tryLoadRecord(var3, 0)) {
            var4 = false;
         }

         return var4;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ZI)Ldw;",
      garbageValue = "1321097000"
   )
   public final ModelData method5015(boolean var1) {
      int var2 = this.maleHeadModel;
      int var3 = this.maleHeadModel2;
      if(var1) {
         var2 = this.femaleHeadModel;
         var3 = this.femaleHeadModel2;
      }

      if(var2 == -1) {
         return null;
      } else {
         ModelData var4 = ModelData.method2620(class150.ItemDefinition_modelIndexCache, var2, 0);
         if(var3 != -1) {
            ModelData var5 = ModelData.method2620(class150.ItemDefinition_modelIndexCache, var3, 0);
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
               var4.method2635(this.textureToReplace[var7], this.textToReplaceWith[var7]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-745601432"
   )
   public int method4979(int var1, int var2) {
      return PendingSpawn.method1591(this.field3615, var1, var2);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "2042044771"
   )
   public String method4980(int var1, String var2) {
      return IndexData.method4604(this.field3615, var1, var2);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-84"
   )
   public int method4981() {
      return this.team != -1 && this.inventoryActions != null?(this.team >= 0?(this.inventoryActions[this.team] != null?this.team:-1):("Drop".equalsIgnoreCase(this.inventoryActions[4])?4:-1)):-1;
   }
}
