import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jm")
@Implements("ItemComposition")
public class ItemComposition extends CacheableNode {
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Liv;"
   )
   @Export("item_ref")
   public static IndexDataBase item_ref;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lgj;"
   )
   @Export("items")
   static NodeCache items;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lgj;"
   )
   @Export("itemModelCache")
   static NodeCache itemModelCache;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lgj;"
   )
   @Export("itemSpriteCache")
   static NodeCache itemSpriteCache;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1416216841
   )
   @Export("id")
   public int id;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1003175805
   )
   @Export("inventoryModel")
   int inventoryModel;
   @ObfuscatedName("y")
   @Export("name")
   public String name;
   @ObfuscatedName("c")
   @Export("colourToReplace")
   short[] colourToReplace;
   @ObfuscatedName("e")
   @Export("colourToReplaceWith")
   short[] colourToReplaceWith;
   @ObfuscatedName("t")
   @Export("textureToReplace")
   short[] textureToReplace;
   @ObfuscatedName("u")
   @Export("textToReplaceWith")
   short[] textToReplaceWith;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1373414967
   )
   @Export("zoom2d")
   public int zoom2d;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 100799771
   )
   @Export("xan2d")
   public int xan2d;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -581181377
   )
   @Export("yan2d")
   public int yan2d;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 1680558411
   )
   @Export("zan2d")
   public int zan2d;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -410592857
   )
   @Export("offsetX2d")
   public int offsetX2d;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1341591795
   )
   @Export("offsetY2d")
   public int offsetY2d;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 461690065
   )
   @Export("isStackable")
   public int isStackable;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -387351305
   )
   @Export("price")
   public int price;
   @ObfuscatedName("ad")
   @Export("isMembers")
   public boolean isMembers;
   @ObfuscatedName("ac")
   @Export("groundActions")
   public String[] groundActions;
   @ObfuscatedName("ay")
   @Export("inventoryActions")
   public String[] inventoryActions;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -941419297
   )
   @Export("shiftClickIndex")
   int shiftClickIndex;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 1923788853
   )
   @Export("maleModel")
   int maleModel;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -382275523
   )
   @Export("maleModel1")
   int maleModel1;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 704404441
   )
   @Export("maleOffset")
   int maleOffset;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -1072292447
   )
   @Export("femaleModel")
   int femaleModel;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -379908107
   )
   @Export("femaleModel1")
   int femaleModel1;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 1853563943
   )
   @Export("femaleOffset")
   int femaleOffset;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -33993557
   )
   @Export("maleModel2")
   int maleModel2;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -1199645199
   )
   @Export("femaleModel2")
   int femaleModel2;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 1589540563
   )
   @Export("maleHeadModel")
   int maleHeadModel;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -1952256067
   )
   @Export("maleHeadModel2")
   int maleHeadModel2;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -116729961
   )
   @Export("femaleHeadModel")
   int femaleHeadModel;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -704655001
   )
   @Export("femaleHeadModel2")
   int femaleHeadModel2;
   @ObfuscatedName("av")
   @Export("countObj")
   int[] countObj;
   @ObfuscatedName("ab")
   @Export("countCo")
   int[] countCo;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -756884735
   )
   @Export("note")
   public int note;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 1454244321
   )
   @Export("notedTemplate")
   public int notedTemplate;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -1333414243
   )
   @Export("resizeX")
   int resizeX;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 224312623
   )
   @Export("resizeY")
   int resizeY;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 1961657059
   )
   @Export("resizeZ")
   int resizeZ;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = -538021375
   )
   @Export("ambient")
   public int ambient;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = 1944579415
   )
   @Export("contrast")
   public int contrast;
   @ObfuscatedName("bx")
   @ObfuscatedGetter(
      intValue = -528641629
   )
   @Export("team")
   public int team;
   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "Lgx;"
   )
   @Export("params")
   IterableHashTable params;
   @ObfuscatedName("br")
   @Export("isTradable")
   public boolean isTradable;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = -1906674555
   )
   @Export("unnotedId")
   int unnotedId;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = 1119437519
   )
   @Export("notedId")
   int notedId;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = 1769711735
   )
   @Export("placeholderId")
   public int placeholderId;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = -229202449
   )
   @Export("placeholderTemplateId")
   public int placeholderTemplateId;

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
      this.shiftClickIndex = -2;
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
      this.team = 0;
      this.isTradable = false;
      this.unnotedId = -1;
      this.notedId = -1;
      this.placeholderId = -1;
      this.placeholderTemplateId = -1;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   @Export("post")
   @Hook(
      value = "postItemComposition",
      end = true
   )
   void post() {
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgy;I)V",
      garbageValue = "-1275314204"
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

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Lgy;II)V",
      garbageValue = "1957958690"
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
            this.shiftClickIndex = var1.readByte();
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
            this.team = var1.readUnsignedByte();
         } else if(var2 == 139) {
            this.unnotedId = var1.readUnsignedShort();
         } else if(var2 == 140) {
            this.notedId = var1.readUnsignedShort();
         } else if(var2 == 148) {
            this.placeholderId = var1.readUnsignedShort();
         } else if(var2 == 149) {
            this.placeholderTemplateId = var1.readUnsignedShort();
         } else if(var2 == 249) {
            this.params = CacheFile.readStringIntParameters(var1, this.params);
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljm;Ljm;B)V",
      garbageValue = "-126"
   )
   @Export("updateNote")
   void updateNote(ItemComposition var1, ItemComposition var2) {
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

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljm;Ljm;I)V",
      garbageValue = "-1346032064"
   )
   void method5106(ItemComposition var1, ItemComposition var2) {
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
      this.team = var2.team;
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
      signature = "(Ljm;Ljm;B)V",
      garbageValue = "-52"
   )
   void method5137(ItemComposition var1, ItemComposition var2) {
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
      signature = "(II)Ldo;",
      garbageValue = "1323080318"
   )
   public final ModelData method5108(int var1) {
      int var3;
      if(this.countObj != null && var1 > 1) {
         int var2 = -1;

         for(var3 = 0; var3 < 10; ++var3) {
            if(var1 >= this.countCo[var3] && this.countCo[var3] != 0) {
               var2 = this.countObj[var3];
            }
         }

         if(var2 != -1) {
            return class120.getItemDefinition(var2).method5108(1);
         }
      }

      ModelData var4 = ModelData.method2619(VarCInt.ItemDefinition_modelIndexCache, this.inventoryModel, 0);
      if(var4 == null) {
         return null;
      } else {
         if(this.resizeX != 128 || this.resizeY != 128 || this.resizeZ != 128) {
            var4.method2674(this.resizeX, this.resizeY, this.resizeZ);
         }

         if(this.colourToReplace != null) {
            for(var3 = 0; var3 < this.colourToReplace.length; ++var3) {
               var4.recolor(this.colourToReplace[var3], this.colourToReplaceWith[var3]);
            }
         }

         if(this.textureToReplace != null) {
            for(var3 = 0; var3 < this.textureToReplace.length; ++var3) {
               var4.method2632(this.textureToReplace[var3], this.textToReplaceWith[var3]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)Ldk;",
      garbageValue = "1267620744"
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
            return class120.getItemDefinition(var2).getModel(1);
         }
      }

      Model var5 = (Model)itemModelCache.get((long)this.id);
      if(var5 != null) {
         return var5;
      } else {
         ModelData var6 = ModelData.method2619(VarCInt.ItemDefinition_modelIndexCache, this.inventoryModel, 0);
         if(var6 == null) {
            return null;
         } else {
            if(this.resizeX != 128 || this.resizeY != 128 || this.resizeZ != 128) {
               var6.method2674(this.resizeX, this.resizeY, this.resizeZ);
            }

            int var4;
            if(this.colourToReplace != null) {
               for(var4 = 0; var4 < this.colourToReplace.length; ++var4) {
                  var6.recolor(this.colourToReplace[var4], this.colourToReplaceWith[var4]);
               }
            }

            if(this.textureToReplace != null) {
               for(var4 = 0; var4 < this.textureToReplace.length; ++var4) {
                  var6.method2632(this.textureToReplace[var4], this.textToReplaceWith[var4]);
               }
            }

            var5 = var6.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
            var5.field1636 = true;
            itemModelCache.put(var5, (long)this.id);
            return var5;
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)Ljm;",
      garbageValue = "-720159989"
   )
   public ItemComposition method5105(int var1) {
      if(this.countObj != null && var1 > 1) {
         int var2 = -1;

         for(int var3 = 0; var3 < 10; ++var3) {
            if(var1 >= this.countCo[var3] && this.countCo[var3] != 0) {
               var2 = this.countObj[var3];
            }
         }

         if(var2 != -1) {
            return class120.getItemDefinition(var2);
         }
      }

      return this;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(ZI)Z",
      garbageValue = "-1526419029"
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
         if(!VarCInt.ItemDefinition_modelIndexCache.tryLoadRecord(var2, 0)) {
            var5 = false;
         }

         if(var3 != -1 && !VarCInt.ItemDefinition_modelIndexCache.tryLoadRecord(var3, 0)) {
            var5 = false;
         }

         if(var4 != -1 && !VarCInt.ItemDefinition_modelIndexCache.tryLoadRecord(var4, 0)) {
            var5 = false;
         }

         return var5;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(ZI)Ldo;",
      garbageValue = "798918822"
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
         ModelData var5 = ModelData.method2619(VarCInt.ItemDefinition_modelIndexCache, var2, 0);
         if(var3 != -1) {
            ModelData var6 = ModelData.method2619(VarCInt.ItemDefinition_modelIndexCache, var3, 0);
            if(var4 != -1) {
               ModelData var7 = ModelData.method2619(VarCInt.ItemDefinition_modelIndexCache, var4, 0);
               ModelData[] var8 = new ModelData[]{var5, var6, var7};
               var5 = new ModelData(var8, 3);
            } else {
               ModelData[] var10 = new ModelData[]{var5, var6};
               var5 = new ModelData(var10, 2);
            }
         }

         if(!var1 && this.maleOffset != 0) {
            var5.method2630(0, this.maleOffset, 0);
         }

         if(var1 && this.femaleOffset != 0) {
            var5.method2630(0, this.femaleOffset, 0);
         }

         int var9;
         if(this.colourToReplace != null) {
            for(var9 = 0; var9 < this.colourToReplace.length; ++var9) {
               var5.recolor(this.colourToReplace[var9], this.colourToReplaceWith[var9]);
            }
         }

         if(this.textureToReplace != null) {
            for(var9 = 0; var9 < this.textureToReplace.length; ++var9) {
               var5.method2632(this.textureToReplace[var9], this.textToReplaceWith[var9]);
            }
         }

         return var5;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ZI)Z",
      garbageValue = "2145942364"
   )
   public final boolean method5143(boolean var1) {
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
         if(!VarCInt.ItemDefinition_modelIndexCache.tryLoadRecord(var2, 0)) {
            var4 = false;
         }

         if(var3 != -1 && !VarCInt.ItemDefinition_modelIndexCache.tryLoadRecord(var3, 0)) {
            var4 = false;
         }

         return var4;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(ZI)Ldo;",
      garbageValue = "2059212992"
   )
   public final ModelData method5150(boolean var1) {
      int var2 = this.maleHeadModel;
      int var3 = this.maleHeadModel2;
      if(var1) {
         var2 = this.femaleHeadModel;
         var3 = this.femaleHeadModel2;
      }

      if(var2 == -1) {
         return null;
      } else {
         ModelData var4 = ModelData.method2619(VarCInt.ItemDefinition_modelIndexCache, var2, 0);
         if(var3 != -1) {
            ModelData var5 = ModelData.method2619(VarCInt.ItemDefinition_modelIndexCache, var3, 0);
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
               var4.method2632(this.textureToReplace[var7], this.textToReplaceWith[var7]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-746006766"
   )
   public int method5103(int var1, int var2) {
      IterableHashTable var4 = this.params;
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

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-709555177"
   )
   public String method5111(int var1, String var2) {
      return CombatInfoListHolder.method1822(this.params, var1, var2);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "-94"
   )
   @Export("getShiftClickActionIndex")
   public int getShiftClickActionIndex() {
      return this.shiftClickIndex != -1 && this.inventoryActions != null?(this.shiftClickIndex >= 0?(this.inventoryActions[this.shiftClickIndex] != null?this.shiftClickIndex:-1):("Drop".equalsIgnoreCase(this.inventoryActions[4])?4:-1)):-1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)Liy;",
      garbageValue = "657771191"
   )
   public static VarCInt method5162(int var0) {
      VarCInt var1 = (VarCInt)VarCInt.field3279.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = VarCInt.field3278.getConfigData(19, var0);
         var1 = new VarCInt();
         if(var2 != null) {
            var1.method4845(new Buffer(var2));
         }

         VarCInt.field3279.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("ju")
   @ObfuscatedSignature(
      signature = "([Lhl;II)V",
      garbageValue = "2020592880"
   )
   static final void method5125(Widget[] var0, int var1) {
      for(int var2 = 0; var2 < var0.length; ++var2) {
         Widget var3 = var0[var2];
         if(var3 != null && var3.parentId == var1) {
            boolean var4;
            if(var3.hasScript) {
               var4 = var3.isHidden;
               if(var4) {
                  continue;
               }
            }

            if(var3.type == 0) {
               if(!var3.hasScript) {
                  var4 = var3.isHidden;
                  if(var4 && var3 != class37.field329) {
                     continue;
                  }
               }

               method5125(var0, var3.id);
               if(var3.children != null) {
                  method5125(var3.children, var3.id);
               }

               WidgetNode var7 = (WidgetNode)Client.componentTable.get((long)var3.id);
               if(var7 != null) {
                  WorldMapType2.method498(var7.id);
               }
            }

            if(var3.type == 6) {
               int var5;
               if(var3.field2670 != -1 || var3.field2671 != -1) {
                  var4 = class9.method96(var3);
                  if(var4) {
                     var5 = var3.field2671;
                  } else {
                     var5 = var3.field2670;
                  }

                  if(var5 != -1) {
                     Sequence var6 = class137.getAnimation(var5);

                     for(var3.field2718 += Client.field654; var3.field2718 > var6.frameLengths[var3.field2746]; DState.method3548(var3)) {
                        var3.field2718 -= var6.frameLengths[var3.field2746];
                        ++var3.field2746;
                        if(var3.field2746 >= var6.frameIDs.length) {
                           var3.field2746 -= var6.frameStep;
                           if(var3.field2746 < 0 || var3.field2746 >= var6.frameIDs.length) {
                              var3.field2746 = 0;
                           }
                        }
                     }
                  }
               }

               if(var3.field2661 != 0 && !var3.hasScript) {
                  int var8 = var3.field2661 >> 16;
                  var5 = var3.field2661 << 16 >> 16;
                  var8 *= Client.field654;
                  var5 *= Client.field654;
                  var3.rotationX = var8 + var3.rotationX & 2047;
                  var3.rotationZ = var5 + var3.rotationZ & 2047;
                  DState.method3548(var3);
               }
            }
         }
      }

   }
}
