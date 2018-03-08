import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jy")
@Implements("ItemComposition")
public class ItemComposition extends CacheableNode {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Ljc;"
   )
   @Export("item_ref")
   public static IndexDataBase item_ref;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Ljc;"
   )
   @Export("ItemDefinition_modelIndexCache")
   public static IndexDataBase ItemDefinition_modelIndexCache;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   @Export("items")
   public static NodeCache items;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   @Export("itemModelCache")
   public static NodeCache itemModelCache;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   @Export("itemSpriteCache")
   public static NodeCache itemSpriteCache;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1176182919
   )
   @Export("id")
   public int id;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -2036926763
   )
   @Export("inventoryModel")
   int inventoryModel;
   @ObfuscatedName("j")
   @Export("name")
   public String name;
   @ObfuscatedName("k")
   @Export("colourToReplace")
   short[] colourToReplace;
   @ObfuscatedName("z")
   @Export("colourToReplaceWith")
   short[] colourToReplaceWith;
   @ObfuscatedName("w")
   @Export("textureToReplace")
   short[] textureToReplace;
   @ObfuscatedName("s")
   @Export("textToReplaceWith")
   short[] textToReplaceWith;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 840327005
   )
   @Export("zoom2d")
   public int zoom2d;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 76872445
   )
   @Export("xan2d")
   public int xan2d;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1293021739
   )
   @Export("yan2d")
   public int yan2d;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -2034570751
   )
   @Export("zan2d")
   public int zan2d;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 355929307
   )
   @Export("offsetX2d")
   public int offsetX2d;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 710217861
   )
   @Export("offsetY2d")
   public int offsetY2d;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -1550572645
   )
   @Export("isStackable")
   public int isStackable;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -817744507
   )
   @Export("price")
   public int price;
   @ObfuscatedName("av")
   @Export("isMembers")
   public boolean isMembers;
   @ObfuscatedName("aj")
   @Export("groundActions")
   public String[] groundActions;
   @ObfuscatedName("ae")
   @Export("inventoryActions")
   public String[] inventoryActions;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 562284763
   )
   @Export("team")
   int team;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -1613994995
   )
   @Export("maleModel")
   int maleModel;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 329428319
   )
   @Export("maleModel1")
   int maleModel1;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -1727650589
   )
   @Export("maleOffset")
   int maleOffset;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -1460806763
   )
   @Export("femaleModel")
   int femaleModel;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 697467801
   )
   @Export("femaleModel1")
   int femaleModel1;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -882043255
   )
   @Export("femaleOffset")
   int femaleOffset;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 2008314295
   )
   @Export("maleModel2")
   int maleModel2;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -928667339
   )
   @Export("femaleModel2")
   int femaleModel2;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 1411595257
   )
   @Export("maleHeadModel")
   int maleHeadModel;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 2126902273
   )
   @Export("maleHeadModel2")
   int maleHeadModel2;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 1442785309
   )
   @Export("femaleHeadModel")
   int femaleHeadModel;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 265219691
   )
   @Export("femaleHeadModel2")
   int femaleHeadModel2;
   @ObfuscatedName("aq")
   @Export("countObj")
   int[] countObj;
   @ObfuscatedName("aa")
   @Export("countCo")
   int[] countCo;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 926055911
   )
   @Export("note")
   public int note;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -1645636803
   )
   @Export("notedTemplate")
   public int notedTemplate;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -1223576679
   )
   @Export("resizeX")
   int resizeX;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 272331583
   )
   @Export("resizeY")
   int resizeY;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -423805169
   )
   @Export("resizeZ")
   int resizeZ;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = 1414626997
   )
   @Export("ambient")
   public int ambient;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = 1328301729
   )
   @Export("contrast")
   public int contrast;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = -311654589
   )
   @Export("int1")
   public int int1;
   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "Lhq;"
   )
   IterableHashTable field3694;
   @ObfuscatedName("be")
   @Export("isTradable")
   public boolean isTradable;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = -1262590045
   )
   @Export("unnotedId")
   int unnotedId;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = -1323620799
   )
   @Export("notedId")
   int notedId;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = 772887111
   )
   @Export("int2")
   public int int2;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = 577127199
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

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1403793057"
   )
   @Export("post")
   void post() {
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lgb;B)V",
      garbageValue = "-1"
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

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lgb;II)V",
      garbageValue = "-622474899"
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
            this.field3694 = class2.readStringIntParameters(var1, this.field3694);
         }
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljy;Ljy;I)V",
      garbageValue = "2043970354"
   )
   void method5042(ItemComposition var1, ItemComposition var2) {
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

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljy;Ljy;I)V",
      garbageValue = "708364987"
   )
   void method5043(ItemComposition var1, ItemComposition var2) {
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

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljy;Ljy;I)V",
      garbageValue = "-1279001427"
   )
   void method5073(ItemComposition var1, ItemComposition var2) {
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

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)Ldi;",
      garbageValue = "75527171"
   )
   public final ModelData method5082(int var1) {
      int var3;
      if(this.countObj != null && var1 > 1) {
         int var2 = -1;

         for(var3 = 0; var3 < 10; ++var3) {
            if(var1 >= this.countCo[var3] && this.countCo[var3] != 0) {
               var2 = this.countObj[var3];
            }
         }

         if(var2 != -1) {
            return class81.getItemDefinition(var2).method5082(1);
         }
      }

      ModelData var4 = ModelData.method2594(ItemDefinition_modelIndexCache, this.inventoryModel, 0);
      if(var4 == null) {
         return null;
      } else {
         if(this.resizeX != 128 || this.resizeY != 128 || this.resizeZ != 128) {
            var4.method2610(this.resizeX, this.resizeY, this.resizeZ);
         }

         if(this.colourToReplace != null) {
            for(var3 = 0; var3 < this.colourToReplace.length; ++var3) {
               var4.recolor(this.colourToReplace[var3], this.colourToReplaceWith[var3]);
            }
         }

         if(this.textureToReplace != null) {
            for(var3 = 0; var3 < this.textureToReplace.length; ++var3) {
               var4.method2609(this.textureToReplace[var3], this.textToReplaceWith[var3]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)Lek;",
      garbageValue = "281990800"
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
            return class81.getItemDefinition(var2).getModel(1);
         }
      }

      Model var5 = (Model)itemModelCache.get((long)this.id);
      if(var5 != null) {
         return var5;
      } else {
         ModelData var6 = ModelData.method2594(ItemDefinition_modelIndexCache, this.inventoryModel, 0);
         if(var6 == null) {
            return null;
         } else {
            if(this.resizeX != 128 || this.resizeY != 128 || this.resizeZ != 128) {
               var6.method2610(this.resizeX, this.resizeY, this.resizeZ);
            }

            int var4;
            if(this.colourToReplace != null) {
               for(var4 = 0; var4 < this.colourToReplace.length; ++var4) {
                  var6.recolor(this.colourToReplace[var4], this.colourToReplaceWith[var4]);
               }
            }

            if(this.textureToReplace != null) {
               for(var4 = 0; var4 < this.textureToReplace.length; ++var4) {
                  var6.method2609(this.textureToReplace[var4], this.textToReplaceWith[var4]);
               }
            }

            var5 = var6.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
            var5.field1849 = true;
            itemModelCache.put(var5, (long)this.id);
            return var5;
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)Ljy;",
      garbageValue = "504858178"
   )
   public ItemComposition method5049(int var1) {
      if(this.countObj != null && var1 > 1) {
         int var2 = -1;

         for(int var3 = 0; var3 < 10; ++var3) {
            if(var1 >= this.countCo[var3] && this.countCo[var3] != 0) {
               var2 = this.countObj[var3];
            }
         }

         if(var2 != -1) {
            return class81.getItemDefinition(var2);
         }
      }

      return this;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(ZB)Z",
      garbageValue = "-22"
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
         if(!ItemDefinition_modelIndexCache.tryLoadRecord(var2, 0)) {
            var5 = false;
         }

         if(var3 != -1 && !ItemDefinition_modelIndexCache.tryLoadRecord(var3, 0)) {
            var5 = false;
         }

         if(var4 != -1 && !ItemDefinition_modelIndexCache.tryLoadRecord(var4, 0)) {
            var5 = false;
         }

         return var5;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(ZI)Ldi;",
      garbageValue = "-1244525124"
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
         ModelData var5 = ModelData.method2594(ItemDefinition_modelIndexCache, var2, 0);
         if(var3 != -1) {
            ModelData var6 = ModelData.method2594(ItemDefinition_modelIndexCache, var3, 0);
            if(var4 != -1) {
               ModelData var7 = ModelData.method2594(ItemDefinition_modelIndexCache, var4, 0);
               ModelData[] var8 = new ModelData[]{var5, var6, var7};
               var5 = new ModelData(var8, 3);
            } else {
               ModelData[] var10 = new ModelData[]{var5, var6};
               var5 = new ModelData(var10, 2);
            }
         }

         if(!var1 && this.maleOffset != 0) {
            var5.method2607(0, this.maleOffset, 0);
         }

         if(var1 && this.femaleOffset != 0) {
            var5.method2607(0, this.femaleOffset, 0);
         }

         int var9;
         if(this.colourToReplace != null) {
            for(var9 = 0; var9 < this.colourToReplace.length; ++var9) {
               var5.recolor(this.colourToReplace[var9], this.colourToReplaceWith[var9]);
            }
         }

         if(this.textureToReplace != null) {
            for(var9 = 0; var9 < this.textureToReplace.length; ++var9) {
               var5.method2609(this.textureToReplace[var9], this.textToReplaceWith[var9]);
            }
         }

         return var5;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ZI)Z",
      garbageValue = "-1363470269"
   )
   public final boolean method5045(boolean var1) {
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
         if(!ItemDefinition_modelIndexCache.tryLoadRecord(var2, 0)) {
            var4 = false;
         }

         if(var3 != -1 && !ItemDefinition_modelIndexCache.tryLoadRecord(var3, 0)) {
            var4 = false;
         }

         return var4;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ZI)Ldi;",
      garbageValue = "-584691050"
   )
   public final ModelData method5050(boolean var1) {
      int var2 = this.maleHeadModel;
      int var3 = this.maleHeadModel2;
      if(var1) {
         var2 = this.femaleHeadModel;
         var3 = this.femaleHeadModel2;
      }

      if(var2 == -1) {
         return null;
      } else {
         ModelData var4 = ModelData.method2594(ItemDefinition_modelIndexCache, var2, 0);
         if(var3 != -1) {
            ModelData var5 = ModelData.method2594(ItemDefinition_modelIndexCache, var3, 0);
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
               var4.method2609(this.textureToReplace[var7], this.textToReplaceWith[var7]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1513262666"
   )
   public int method5051(int var1, int var2) {
      return class297.method5284(this.field3694, var1, var2);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-694495622"
   )
   public String method5052(int var1, String var2) {
      IterableHashTable var4 = this.field3694;
      String var3;
      if(var4 == null) {
         var3 = var2;
      } else {
         ObjectNode var5 = (ObjectNode)var4.get((long)var1);
         if(var5 == null) {
            var3 = var2;
         } else {
            var3 = (String)var5.value;
         }
      }

      return var3;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1438816588"
   )
   public int method5080() {
      return this.team != -1 && this.inventoryActions != null?(this.team >= 0?(this.inventoryActions[this.team] != null?this.team:-1):("Drop".equalsIgnoreCase(this.inventoryActions[4])?4:-1)):-1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljc;Ljc;I)I",
      garbageValue = "-419313500"
   )
   static int method5058(IndexDataBase var0, IndexDataBase var1) {
      int var2 = 0;
      if(var0.tryLoadRecordByNames("title.jpg", "")) {
         ++var2;
      }

      if(var1.tryLoadRecordByNames("logo", "")) {
         ++var2;
      }

      if(var1.tryLoadRecordByNames("logo_deadman_mode", "")) {
         ++var2;
      }

      if(var1.tryLoadRecordByNames("titlebox", "")) {
         ++var2;
      }

      if(var1.tryLoadRecordByNames("titlebutton", "")) {
         ++var2;
      }

      if(var1.tryLoadRecordByNames("runes", "")) {
         ++var2;
      }

      if(var1.tryLoadRecordByNames("title_mute", "")) {
         ++var2;
      }

      if(var1.tryLoadRecordByNames("options_radio_buttons,0", "")) {
         ++var2;
      }

      if(var1.tryLoadRecordByNames("options_radio_buttons,2", "")) {
         ++var2;
      }

      if(var1.tryLoadRecordByNames("options_radio_buttons,4", "")) {
         ++var2;
      }

      if(var1.tryLoadRecordByNames("options_radio_buttons,6", "")) {
         ++var2;
      }

      var1.tryLoadRecordByNames("sl_back", "");
      var1.tryLoadRecordByNames("sl_flags", "");
      var1.tryLoadRecordByNames("sl_arrows", "");
      var1.tryLoadRecordByNames("sl_stars", "");
      var1.tryLoadRecordByNames("sl_button", "");
      return var2;
   }
}
