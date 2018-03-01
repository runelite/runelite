import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jx")
@Implements("ItemComposition")
public class ItemComposition extends CacheableNode {
   @ObfuscatedName("s")
   @Export("isMembersWorld")
   public static boolean isMembersWorld;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 585914961
   )
   public static int field3643;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   @Export("items")
   static NodeCache items;
   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   @Export("itemModelCache")
   static NodeCache itemModelCache;
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lhp;"
   )
   @Export("itemSpriteCache")
   public static NodeCache itemSpriteCache;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 633911801
   )
   @Export("id")
   public int id;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 972295667
   )
   @Export("inventoryModel")
   int inventoryModel;
   @ObfuscatedName("q")
   @Export("name")
   public String name;
   @ObfuscatedName("v")
   @Export("colourToReplace")
   short[] colourToReplace;
   @ObfuscatedName("f")
   @Export("colourToReplaceWith")
   short[] colourToReplaceWith;
   @ObfuscatedName("b")
   @Export("textureToReplace")
   short[] textureToReplace;
   @ObfuscatedName("c")
   @Export("textToReplaceWith")
   short[] textToReplaceWith;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -750567197
   )
   @Export("zoom2d")
   public int zoom2d;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 950455321
   )
   @Export("xan2d")
   public int xan2d;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 356420187
   )
   @Export("yan2d")
   public int yan2d;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 927280511
   )
   @Export("zan2d")
   public int zan2d;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1542858907
   )
   @Export("offsetX2d")
   public int offsetX2d;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -2047637651
   )
   @Export("offsetY2d")
   public int offsetY2d;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -1461663515
   )
   @Export("isStackable")
   public int isStackable;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 605430085
   )
   @Export("price")
   public int price;
   @ObfuscatedName("ac")
   @Export("isMembers")
   public boolean isMembers;
   @ObfuscatedName("aw")
   @Export("groundActions")
   public String[] groundActions;
   @ObfuscatedName("as")
   @Export("inventoryActions")
   public String[] inventoryActions;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -1331211315
   )
   @Export("team")
   int team;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 297687269
   )
   @Export("maleModel")
   int maleModel;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -965692687
   )
   @Export("maleModel1")
   int maleModel1;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -1116505733
   )
   @Export("maleOffset")
   int maleOffset;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 1673241821
   )
   @Export("femaleModel")
   int femaleModel;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 1540728009
   )
   @Export("femaleModel1")
   int femaleModel1;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -1289662813
   )
   @Export("femaleOffset")
   int femaleOffset;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 429693959
   )
   @Export("maleModel2")
   int maleModel2;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -1543668745
   )
   @Export("femaleModel2")
   int femaleModel2;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 1282897865
   )
   @Export("maleHeadModel")
   int maleHeadModel;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -477898829
   )
   @Export("maleHeadModel2")
   int maleHeadModel2;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 322356187
   )
   @Export("femaleHeadModel")
   int femaleHeadModel;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 1431490653
   )
   @Export("femaleHeadModel2")
   int femaleHeadModel2;
   @ObfuscatedName("ah")
   @Export("countObj")
   int[] countObj;
   @ObfuscatedName("ab")
   @Export("countCo")
   int[] countCo;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 1859500913
   )
   @Export("note")
   public int note;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -1644483151
   )
   @Export("notedTemplate")
   public int notedTemplate;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -897506735
   )
   @Export("resizeX")
   int resizeX;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -1032878267
   )
   @Export("resizeY")
   int resizeY;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -1381027523
   )
   @Export("resizeZ")
   int resizeZ;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = 799303271
   )
   @Export("ambient")
   public int ambient;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = 1106960249
   )
   @Export("contrast")
   public int contrast;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = -241335089
   )
   @Export("int1")
   public int int1;
   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "Lhd;"
   )
   IterableHashTable field3689;
   @ObfuscatedName("bs")
   @Export("isTradable")
   public boolean isTradable;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = 1122950513
   )
   @Export("unnotedId")
   int unnotedId;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = -256150781
   )
   @Export("notedId")
   int notedId;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = -745149361
   )
   @Export("int2")
   public int int2;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = -836925925
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

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2081361791"
   )
   @Export("post")
   void post() {
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lgy;I)V",
      garbageValue = "386742570"
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
      signature = "(Lgy;IS)V",
      garbageValue = "-25748"
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
            this.contrast = var1.readByte();
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
            this.field3689 = class167.readStringIntParameters(var1, this.field3689);
         }
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Ljx;Ljx;I)V",
      garbageValue = "-1069814152"
   )
   void method5220(ItemComposition var1, ItemComposition var2) {
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

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Ljx;Ljx;I)V",
      garbageValue = "-590944437"
   )
   void method5161(ItemComposition var1, ItemComposition var2) {
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

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljx;Ljx;I)V",
      garbageValue = "-604614484"
   )
   void method5162(ItemComposition var1, ItemComposition var2) {
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

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)Ldf;",
      garbageValue = "-293513901"
   )
   public final ModelData method5163(int var1) {
      int var3;
      if(this.countObj != null && var1 > 1) {
         int var2 = -1;

         for(var3 = 0; var3 < 10; ++var3) {
            if(var1 >= this.countCo[var3] && this.countCo[var3] != 0) {
               var2 = this.countObj[var3];
            }
         }

         if(var2 != -1) {
            return class251.getItemDefinition(var2).method5163(1);
         }
      }

      ModelData var4 = ModelData.method2660(class288.ItemDefinition_modelIndexCache, this.inventoryModel, 0);
      if(var4 == null) {
         return null;
      } else {
         if(this.resizeX != 128 || this.resizeY != 128 || this.resizeZ != 128) {
            var4.method2676(this.resizeX, this.resizeY, this.resizeZ);
         }

         if(this.colourToReplace != null) {
            for(var3 = 0; var3 < this.colourToReplace.length; ++var3) {
               var4.recolor(this.colourToReplace[var3], this.colourToReplaceWith[var3]);
            }
         }

         if(this.textureToReplace != null) {
            for(var3 = 0; var3 < this.textureToReplace.length; ++var3) {
               var4.method2674(this.textureToReplace[var3], this.textToReplaceWith[var3]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)Lel;",
      garbageValue = "-1872821875"
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
            return class251.getItemDefinition(var2).getModel(1);
         }
      }

      Model var5 = (Model)itemModelCache.get((long)this.id);
      if(var5 != null) {
         return var5;
      } else {
         ModelData var6 = ModelData.method2660(class288.ItemDefinition_modelIndexCache, this.inventoryModel, 0);
         if(var6 == null) {
            return null;
         } else {
            if(this.resizeX != 128 || this.resizeY != 128 || this.resizeZ != 128) {
               var6.method2676(this.resizeX, this.resizeY, this.resizeZ);
            }

            int var4;
            if(this.colourToReplace != null) {
               for(var4 = 0; var4 < this.colourToReplace.length; ++var4) {
                  var6.recolor(this.colourToReplace[var4], this.colourToReplaceWith[var4]);
               }
            }

            if(this.textureToReplace != null) {
               for(var4 = 0; var4 < this.textureToReplace.length; ++var4) {
                  var6.method2674(this.textureToReplace[var4], this.textToReplaceWith[var4]);
               }
            }

            var5 = var6.light(this.ambient + 64, this.contrast * 5 + 768, -50, -10, -50);
            var5.field1859 = true;
            itemModelCache.put(var5, (long)this.id);
            return var5;
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(II)Ljx;",
      garbageValue = "22337279"
   )
   public ItemComposition method5165(int var1) {
      if(this.countObj != null && var1 > 1) {
         int var2 = -1;

         for(int var3 = 0; var3 < 10; ++var3) {
            if(var1 >= this.countCo[var3] && this.countCo[var3] != 0) {
               var2 = this.countObj[var3];
            }
         }

         if(var2 != -1) {
            return class251.getItemDefinition(var2);
         }
      }

      return this;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ZI)Z",
      garbageValue = "-1313831922"
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
         if(!class288.ItemDefinition_modelIndexCache.tryLoadRecord(var2, 0)) {
            var5 = false;
         }

         if(var3 != -1 && !class288.ItemDefinition_modelIndexCache.tryLoadRecord(var3, 0)) {
            var5 = false;
         }

         if(var4 != -1 && !class288.ItemDefinition_modelIndexCache.tryLoadRecord(var4, 0)) {
            var5 = false;
         }

         return var5;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(ZI)Ldf;",
      garbageValue = "1221402871"
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
         ModelData var5 = ModelData.method2660(class288.ItemDefinition_modelIndexCache, var2, 0);
         if(var3 != -1) {
            ModelData var6 = ModelData.method2660(class288.ItemDefinition_modelIndexCache, var3, 0);
            if(var4 != -1) {
               ModelData var7 = ModelData.method2660(class288.ItemDefinition_modelIndexCache, var4, 0);
               ModelData[] var8 = new ModelData[]{var5, var6, var7};
               var5 = new ModelData(var8, 3);
            } else {
               ModelData[] var10 = new ModelData[]{var5, var6};
               var5 = new ModelData(var10, 2);
            }
         }

         if(!var1 && this.maleOffset != 0) {
            var5.method2672(0, this.maleOffset, 0);
         }

         if(var1 && this.femaleOffset != 0) {
            var5.method2672(0, this.femaleOffset, 0);
         }

         int var9;
         if(this.colourToReplace != null) {
            for(var9 = 0; var9 < this.colourToReplace.length; ++var9) {
               var5.recolor(this.colourToReplace[var9], this.colourToReplaceWith[var9]);
            }
         }

         if(this.textureToReplace != null) {
            for(var9 = 0; var9 < this.textureToReplace.length; ++var9) {
               var5.method2674(this.textureToReplace[var9], this.textToReplaceWith[var9]);
            }
         }

         return var5;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(ZB)Z",
      garbageValue = "91"
   )
   public final boolean method5168(boolean var1) {
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
         if(!class288.ItemDefinition_modelIndexCache.tryLoadRecord(var2, 0)) {
            var4 = false;
         }

         if(var3 != -1 && !class288.ItemDefinition_modelIndexCache.tryLoadRecord(var3, 0)) {
            var4 = false;
         }

         return var4;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(ZB)Ldf;",
      garbageValue = "1"
   )
   public final ModelData method5167(boolean var1) {
      int var2 = this.maleHeadModel;
      int var3 = this.maleHeadModel2;
      if(var1) {
         var2 = this.femaleHeadModel;
         var3 = this.femaleHeadModel2;
      }

      if(var2 == -1) {
         return null;
      } else {
         ModelData var4 = ModelData.method2660(class288.ItemDefinition_modelIndexCache, var2, 0);
         if(var3 != -1) {
            ModelData var5 = ModelData.method2660(class288.ItemDefinition_modelIndexCache, var3, 0);
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
               var4.method2674(this.textureToReplace[var7], this.textToReplaceWith[var7]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-549511617"
   )
   public int method5210(int var1, int var2) {
      return class47.method699(this.field3689, var1, var2);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;S)Ljava/lang/String;",
      garbageValue = "-14091"
   )
   public String method5171(int var1, String var2) {
      return Huffman.method3512(this.field3689, var1, var2);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "706659621"
   )
   public int method5222() {
      return this.team != -1 && this.inventoryActions != null?(this.team >= 0?(this.inventoryActions[this.team] != null?this.team:-1):("Drop".equalsIgnoreCase(this.inventoryActions[4])?4:-1)):-1;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lgo;I)V",
      garbageValue = "905173872"
   )
   public static void method5206(Huffman var0) {
      class313.huffman = var0;
   }
}
