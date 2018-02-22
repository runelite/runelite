import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jx")
@Implements("ItemComposition")
public class ItemComposition extends CacheableNode {
   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "Lie;"
   )
   @Export("item_ref")
   public static IndexDataBase item_ref;
   @ObfuscatedName("y")
   @Export("isMembersWorld")
   public static boolean isMembersWorld;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   @Export("items")
   public static NodeCache items;
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   @Export("itemModelCache")
   public static NodeCache itemModelCache;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   @Export("itemSpriteCache")
   public static NodeCache itemSpriteCache;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -790477587
   )
   @Export("id")
   public int id;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1826283993
   )
   @Export("inventoryModel")
   int inventoryModel;
   @ObfuscatedName("t")
   @Export("name")
   public String name;
   @ObfuscatedName("f")
   @Export("colourToReplace")
   short[] colourToReplace;
   @ObfuscatedName("m")
   @Export("colourToReplaceWith")
   short[] colourToReplaceWith;
   @ObfuscatedName("x")
   @Export("textureToReplace")
   short[] textureToReplace;
   @ObfuscatedName("w")
   @Export("textToReplaceWith")
   short[] textToReplaceWith;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1534430905
   )
   @Export("zoom2d")
   public int zoom2d;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1923922017
   )
   @Export("xan2d")
   public int xan2d;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 360271719
   )
   @Export("yan2d")
   public int yan2d;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1300418589
   )
   @Export("zan2d")
   public int zan2d;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1313149911
   )
   @Export("offsetX2d")
   public int offsetX2d;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -444423183
   )
   @Export("offsetY2d")
   public int offsetY2d;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 1405595687
   )
   @Export("isStackable")
   public int isStackable;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 1062802101
   )
   @Export("price")
   public int price;
   @ObfuscatedName("am")
   @Export("isMembers")
   public boolean isMembers;
   @ObfuscatedName("aj")
   @Export("groundActions")
   public String[] groundActions;
   @ObfuscatedName("ah")
   @Export("inventoryActions")
   public String[] inventoryActions;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -1648437949
   )
   @Export("team")
   int team;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 322308907
   )
   @Export("maleModel")
   int maleModel;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -1341138523
   )
   @Export("maleModel1")
   int maleModel1;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -684183887
   )
   @Export("maleOffset")
   int maleOffset;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 763567187
   )
   @Export("femaleModel")
   int femaleModel;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -45850055
   )
   @Export("femaleModel1")
   int femaleModel1;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -2012403093
   )
   @Export("femaleOffset")
   int femaleOffset;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 1009956709
   )
   @Export("maleModel2")
   int maleModel2;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -1239386643
   )
   @Export("femaleModel2")
   int femaleModel2;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 533783765
   )
   @Export("maleHeadModel")
   int maleHeadModel;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 929103533
   )
   @Export("maleHeadModel2")
   int maleHeadModel2;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -1299202795
   )
   @Export("femaleHeadModel")
   int femaleHeadModel;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 1060573843
   )
   @Export("femaleHeadModel2")
   int femaleHeadModel2;
   @ObfuscatedName("at")
   @Export("countObj")
   int[] countObj;
   @ObfuscatedName("aa")
   @Export("countCo")
   int[] countCo;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 1384203379
   )
   @Export("note")
   public int note;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -1279081993
   )
   @Export("notedTemplate")
   public int notedTemplate;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -46379857
   )
   @Export("resizeX")
   int resizeX;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -1356445467
   )
   @Export("resizeY")
   int resizeY;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 1150818443
   )
   @Export("resizeZ")
   int resizeZ;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = -277926891
   )
   @Export("ambient")
   public int ambient;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = -1478680633
   )
   @Export("contrast")
   public int contrast;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = 630181405
   )
   @Export("int1")
   public int int1;
   @ObfuscatedName("bf")
   @ObfuscatedSignature(
      signature = "Lgv;"
   )
   IterableHashTable field3573;
   @ObfuscatedName("bp")
   @Export("isTradable")
   public boolean isTradable;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = -786735393
   )
   @Export("unnotedId")
   int unnotedId;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = 17176973
   )
   @Export("notedId")
   int notedId;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = -1962864157
   )
   @Export("int2")
   public int int2;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = 1555779665
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
      garbageValue = "242979941"
   )
   @Export("post")
   void post() {
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lgn;I)V",
      garbageValue = "1058934171"
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
      signature = "(Lgn;II)V",
      garbageValue = "1321829646"
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
            this.field3573 = Tile.readStringIntParameters(var1, this.field3573);
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljx;Ljx;B)V",
      garbageValue = "38"
   )
   void method5002(ItemComposition var1, ItemComposition var2) {
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

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(Ljx;Ljx;I)V",
      garbageValue = "2134130114"
   )
   void method5022(ItemComposition var1, ItemComposition var2) {
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

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Ljx;Ljx;B)V",
      garbageValue = "9"
   )
   void method5035(ItemComposition var1, ItemComposition var2) {
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

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(II)Ldy;",
      garbageValue = "-767743958"
   )
   public final ModelData method5026(int var1) {
      int var3;
      if(this.countObj != null && var1 > 1) {
         int var2 = -1;

         for(var3 = 0; var3 < 10; ++var3) {
            if(var1 >= this.countCo[var3] && this.countCo[var3] != 0) {
               var2 = this.countObj[var3];
            }
         }

         if(var2 != -1) {
            return ContextMenuRow.getItemDefinition(var2).method5026(1);
         }
      }

      ModelData var4 = ModelData.method2601(class18.ItemDefinition_modelIndexCache, this.inventoryModel, 0);
      if(var4 == null) {
         return null;
      } else {
         if(this.resizeX != 128 || this.resizeY != 128 || this.resizeZ != 128) {
            var4.method2616(this.resizeX, this.resizeY, this.resizeZ);
         }

         if(this.colourToReplace != null) {
            for(var3 = 0; var3 < this.colourToReplace.length; ++var3) {
               var4.recolor(this.colourToReplace[var3], this.colourToReplaceWith[var3]);
            }
         }

         if(this.textureToReplace != null) {
            for(var3 = 0; var3 < this.textureToReplace.length; ++var3) {
               var4.method2614(this.textureToReplace[var3], this.textToReplaceWith[var3]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IB)Lee;",
      garbageValue = "46"
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
            return ContextMenuRow.getItemDefinition(var2).getModel(1);
         }
      }

      Model var5 = (Model)itemModelCache.get((long)this.id);
      if(var5 != null) {
         return var5;
      } else {
         ModelData var6 = ModelData.method2601(class18.ItemDefinition_modelIndexCache, this.inventoryModel, 0);
         if(var6 == null) {
            return null;
         } else {
            if(this.resizeX != 128 || this.resizeY != 128 || this.resizeZ != 128) {
               var6.method2616(this.resizeX, this.resizeY, this.resizeZ);
            }

            int var4;
            if(this.colourToReplace != null) {
               for(var4 = 0; var4 < this.colourToReplace.length; ++var4) {
                  var6.recolor(this.colourToReplace[var4], this.colourToReplaceWith[var4]);
               }
            }

            if(this.textureToReplace != null) {
               for(var4 = 0; var4 < this.textureToReplace.length; ++var4) {
                  var6.method2614(this.textureToReplace[var4], this.textToReplaceWith[var4]);
               }
            }

            var5 = var6.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
            var5.field1827 = true;
            itemModelCache.put(var5, (long)this.id);
            return var5;
         }
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)Ljx;",
      garbageValue = "1419577758"
   )
   public ItemComposition method4998(int var1) {
      if(this.countObj != null && var1 > 1) {
         int var2 = -1;

         for(int var3 = 0; var3 < 10; ++var3) {
            if(var1 >= this.countCo[var3] && this.countCo[var3] != 0) {
               var2 = this.countObj[var3];
            }
         }

         if(var2 != -1) {
            return ContextMenuRow.getItemDefinition(var2);
         }
      }

      return this;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(ZB)Z",
      garbageValue = "12"
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
         if(!class18.ItemDefinition_modelIndexCache.tryLoadRecord(var2, 0)) {
            var5 = false;
         }

         if(var3 != -1 && !class18.ItemDefinition_modelIndexCache.tryLoadRecord(var3, 0)) {
            var5 = false;
         }

         if(var4 != -1 && !class18.ItemDefinition_modelIndexCache.tryLoadRecord(var4, 0)) {
            var5 = false;
         }

         return var5;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(ZI)Ldy;",
      garbageValue = "-454266186"
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
         ModelData var5 = ModelData.method2601(class18.ItemDefinition_modelIndexCache, var2, 0);
         if(var3 != -1) {
            ModelData var6 = ModelData.method2601(class18.ItemDefinition_modelIndexCache, var3, 0);
            if(var4 != -1) {
               ModelData var7 = ModelData.method2601(class18.ItemDefinition_modelIndexCache, var4, 0);
               ModelData[] var8 = new ModelData[]{var5, var6, var7};
               var5 = new ModelData(var8, 3);
            } else {
               ModelData[] var10 = new ModelData[]{var5, var6};
               var5 = new ModelData(var10, 2);
            }
         }

         if(!var1 && this.maleOffset != 0) {
            var5.method2612(0, this.maleOffset, 0);
         }

         if(var1 && this.femaleOffset != 0) {
            var5.method2612(0, this.femaleOffset, 0);
         }

         int var9;
         if(this.colourToReplace != null) {
            for(var9 = 0; var9 < this.colourToReplace.length; ++var9) {
               var5.recolor(this.colourToReplace[var9], this.colourToReplaceWith[var9]);
            }
         }

         if(this.textureToReplace != null) {
            for(var9 = 0; var9 < this.textureToReplace.length; ++var9) {
               var5.method2614(this.textureToReplace[var9], this.textToReplaceWith[var9]);
            }
         }

         return var5;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ZI)Z",
      garbageValue = "200008002"
   )
   public final boolean method5010(boolean var1) {
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
         if(!class18.ItemDefinition_modelIndexCache.tryLoadRecord(var2, 0)) {
            var4 = false;
         }

         if(var3 != -1 && !class18.ItemDefinition_modelIndexCache.tryLoadRecord(var3, 0)) {
            var4 = false;
         }

         return var4;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ZB)Ldy;",
      garbageValue = "8"
   )
   public final ModelData method5011(boolean var1) {
      int var2 = this.maleHeadModel;
      int var3 = this.maleHeadModel2;
      if(var1) {
         var2 = this.femaleHeadModel;
         var3 = this.femaleHeadModel2;
      }

      if(var2 == -1) {
         return null;
      } else {
         ModelData var4 = ModelData.method2601(class18.ItemDefinition_modelIndexCache, var2, 0);
         if(var3 != -1) {
            ModelData var5 = ModelData.method2601(class18.ItemDefinition_modelIndexCache, var3, 0);
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
               var4.method2614(this.textureToReplace[var7], this.textToReplaceWith[var7]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "49"
   )
   public int method5012(int var1, int var2) {
      IterableHashTable var4 = this.field3573;
      int var3;
      if(var4 == null) {
         var3 = var2;
      } else {
         IntegerNode var5 = (IntegerNode)var4.get((long)var1);
         if(var5 == null) {
            var3 = var2;
         } else {
            var3 = var5.value;
         }
      }

      return var3;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-1504653087"
   )
   public String method5013(int var1, String var2) {
      return MouseInput.method1038(this.field3573, var1, var2);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-29"
   )
   public int method5014() {
      return this.team != -1 && this.inventoryActions != null?(this.team >= 0?(this.inventoryActions[this.team] != null?this.team:-1):("Drop".equalsIgnoreCase(this.inventoryActions[4])?4:-1)):-1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IZB)Z",
      garbageValue = "-116"
   )
   static boolean method5009(CharSequence var0, int var1, boolean var2) {
      if(var1 >= 2 && var1 <= 36) {
         boolean var3 = false;
         boolean var4 = false;
         int var5 = 0;
         int var6 = var0.length();

         for(int var7 = 0; var7 < var6; ++var7) {
            char var8 = var0.charAt(var7);
            if(var7 == 0) {
               if(var8 == '-') {
                  var3 = true;
                  continue;
               }

               if(var8 == '+') {
                  continue;
               }
            }

            int var10;
            if(var8 >= '0' && var8 <= '9') {
               var10 = var8 - '0';
            } else if(var8 >= 'A' && var8 <= 'Z') {
               var10 = var8 - '7';
            } else {
               if(var8 < 'a' || var8 > 'z') {
                  return false;
               }

               var10 = var8 - 'W';
            }

            if(var10 >= var1) {
               return false;
            }

            if(var3) {
               var10 = -var10;
            }

            int var9 = var10 + var5 * var1;
            if(var9 / var1 != var5) {
               return false;
            }

            var5 = var9;
            var4 = true;
         }

         return var4;
      } else {
         throw new IllegalArgumentException("");
      }
   }
}
