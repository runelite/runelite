import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jh")
@Implements("ItemComposition")
public class ItemComposition extends CacheableNode {
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Ljm;"
   )
   @Export("ItemDefinition_modelIndexCache")
   public static IndexDataBase ItemDefinition_modelIndexCache;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   @Export("items")
   static NodeCache items;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   @Export("itemModelCache")
   static NodeCache itemModelCache;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   @Export("itemSpriteCache")
   static NodeCache itemSpriteCache;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -1034555267
   )
   @Export("id")
   public int id;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 552191123
   )
   @Export("inventoryModel")
   int inventoryModel;
   @ObfuscatedName("m")
   @Export("name")
   public String name;
   @ObfuscatedName("b")
   @Export("colourToReplace")
   short[] colourToReplace;
   @ObfuscatedName("h")
   @Export("colourToReplaceWith")
   short[] colourToReplaceWith;
   @ObfuscatedName("t")
   @Export("textureToReplace")
   short[] textureToReplace;
   @ObfuscatedName("v")
   @Export("textToReplaceWith")
   short[] textToReplaceWith;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1771822335
   )
   @Export("zoom2d")
   public int zoom2d;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 895334683
   )
   @Export("xan2d")
   public int xan2d;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -679676625
   )
   @Export("yan2d")
   public int yan2d;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 38708853
   )
   @Export("zan2d")
   public int zan2d;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1033812727
   )
   @Export("offsetX2d")
   public int offsetX2d;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -49795523
   )
   @Export("offsetY2d")
   public int offsetY2d;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 1361922013
   )
   @Export("isStackable")
   public int isStackable;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 1325296789
   )
   @Export("price")
   public int price;
   @ObfuscatedName("al")
   @Export("isMembers")
   public boolean isMembers;
   @ObfuscatedName("ai")
   @Export("groundActions")
   public String[] groundActions;
   @ObfuscatedName("ab")
   @Export("inventoryActions")
   public String[] inventoryActions;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -122857391
   )
   @Export("team")
   int team;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -1266446809
   )
   @Export("maleModel")
   int maleModel;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -1897620307
   )
   @Export("maleModel1")
   int maleModel1;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -126228773
   )
   @Export("maleOffset")
   int maleOffset;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 1678321903
   )
   @Export("femaleModel")
   int femaleModel;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 1914722319
   )
   @Export("femaleModel1")
   int femaleModel1;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 336499319
   )
   @Export("femaleOffset")
   int femaleOffset;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -1138094871
   )
   @Export("maleModel2")
   int maleModel2;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 807369139
   )
   @Export("femaleModel2")
   int femaleModel2;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 1490052073
   )
   @Export("maleHeadModel")
   int maleHeadModel;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -458419647
   )
   @Export("maleHeadModel2")
   int maleHeadModel2;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 431488037
   )
   @Export("femaleHeadModel")
   int femaleHeadModel;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -1341277777
   )
   @Export("femaleHeadModel2")
   int femaleHeadModel2;
   @ObfuscatedName("at")
   @Export("countObj")
   int[] countObj;
   @ObfuscatedName("av")
   @Export("countCo")
   int[] countCo;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 1371413469
   )
   @Export("note")
   public int note;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 2035277611
   )
   @Export("notedTemplate")
   public int notedTemplate;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 2075645489
   )
   @Export("resizeX")
   int resizeX;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 184766083
   )
   @Export("resizeY")
   int resizeY;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 182368247
   )
   @Export("resizeZ")
   int resizeZ;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = 998726143
   )
   @Export("ambient")
   public int ambient;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = 663477571
   )
   @Export("contrast")
   public int contrast;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = -617679473
   )
   @Export("int1")
   public int int1;
   @ObfuscatedName("ba")
   @ObfuscatedSignature(
      signature = "Lhz;"
   )
   IterableHashTable field3683;
   @ObfuscatedName("bl")
   @Export("isTradable")
   public boolean isTradable;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = 1565677321
   )
   @Export("unnotedId")
   int unnotedId;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = 1557048343
   )
   @Export("notedId")
   int notedId;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = -143668211
   )
   @Export("int2")
   public int int2;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = 1366669303
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

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2098822871"
   )
   @Export("post")
   @Hook(
       value = "postItemComposition",
       end = true
   )
   void post() {
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lgp;I)V",
      garbageValue = "16711680"
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

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Lgp;II)V",
      garbageValue = "84979127"
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
            this.field3683 = class245.readStringIntParameters(var1, this.field3683);
         }
      }

   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljh;Ljh;S)V",
      garbageValue = "9846"
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

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljh;Ljh;I)V",
      garbageValue = "-1370035097"
   )
   void method5058(ItemComposition var1, ItemComposition var2) {
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

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Ljh;Ljh;I)V",
      garbageValue = "335647948"
   )
   void method5059(ItemComposition var1, ItemComposition var2) {
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

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IB)Ldj;",
      garbageValue = "88"
   )
   public final ModelData method5057(int var1) {
      int var3;
      if(this.countObj != null && var1 > 1) {
         int var2 = -1;

         for(var3 = 0; var3 < 10; ++var3) {
            if(var1 >= this.countCo[var3] && this.countCo[var3] != 0) {
               var2 = this.countObj[var3];
            }
         }

         if(var2 != -1) {
            return GameObject.getItemDefinition(var2).method5057(1);
         }
      }

      ModelData var4 = ModelData.method2583(ItemDefinition_modelIndexCache, this.inventoryModel, 0);
      if(var4 == null) {
         return null;
      } else {
         if(this.resizeX != 128 || this.resizeY != 128 || this.resizeZ != 128) {
            var4.method2644(this.resizeX, this.resizeY, this.resizeZ);
         }

         if(this.colourToReplace != null) {
            for(var3 = 0; var3 < this.colourToReplace.length; ++var3) {
               var4.recolor(this.colourToReplace[var3], this.colourToReplaceWith[var3]);
            }
         }

         if(this.textureToReplace != null) {
            for(var3 = 0; var3 < this.textureToReplace.length; ++var3) {
               var4.method2660(this.textureToReplace[var3], this.textToReplaceWith[var3]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)Led;",
      garbageValue = "-449200602"
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
            return GameObject.getItemDefinition(var2).getModel(1);
         }
      }

      Model var5 = (Model)itemModelCache.get((long)this.id);
      if(var5 != null) {
         return var5;
      } else {
         ModelData var6 = ModelData.method2583(ItemDefinition_modelIndexCache, this.inventoryModel, 0);
         if(var6 == null) {
            return null;
         } else {
            if(this.resizeX != 128 || this.resizeY != 128 || this.resizeZ != 128) {
               var6.method2644(this.resizeX, this.resizeY, this.resizeZ);
            }

            int var4;
            if(this.colourToReplace != null) {
               for(var4 = 0; var4 < this.colourToReplace.length; ++var4) {
                  var6.recolor(this.colourToReplace[var4], this.colourToReplaceWith[var4]);
               }
            }

            if(this.textureToReplace != null) {
               for(var4 = 0; var4 < this.textureToReplace.length; ++var4) {
                  var6.method2660(this.textureToReplace[var4], this.textToReplaceWith[var4]);
               }
            }

            var5 = var6.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
            var5.field1850 = true;
            itemModelCache.put(var5, (long)this.id);
            return var5;
         }
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)Ljh;",
      garbageValue = "2130026432"
   )
   public ItemComposition method5062(int var1) {
      if(this.countObj != null && var1 > 1) {
         int var2 = -1;

         for(int var3 = 0; var3 < 10; ++var3) {
            if(var1 >= this.countCo[var3] && this.countCo[var3] != 0) {
               var2 = this.countObj[var3];
            }
         }

         if(var2 != -1) {
            return GameObject.getItemDefinition(var2);
         }
      }

      return this;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(ZI)Z",
      garbageValue = "1486897919"
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

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(ZB)Ldj;",
      garbageValue = "-10"
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
         ModelData var5 = ModelData.method2583(ItemDefinition_modelIndexCache, var2, 0);
         if(var3 != -1) {
            ModelData var6 = ModelData.method2583(ItemDefinition_modelIndexCache, var3, 0);
            if(var4 != -1) {
               ModelData var7 = ModelData.method2583(ItemDefinition_modelIndexCache, var4, 0);
               ModelData[] var8 = new ModelData[]{var5, var6, var7};
               var5 = new ModelData(var8, 3);
            } else {
               ModelData[] var10 = new ModelData[]{var5, var6};
               var5 = new ModelData(var10, 2);
            }
         }

         if(!var1 && this.maleOffset != 0) {
            var5.method2647(0, this.maleOffset, 0);
         }

         if(var1 && this.femaleOffset != 0) {
            var5.method2647(0, this.femaleOffset, 0);
         }

         int var9;
         if(this.colourToReplace != null) {
            for(var9 = 0; var9 < this.colourToReplace.length; ++var9) {
               var5.recolor(this.colourToReplace[var9], this.colourToReplaceWith[var9]);
            }
         }

         if(this.textureToReplace != null) {
            for(var9 = 0; var9 < this.textureToReplace.length; ++var9) {
               var5.method2660(this.textureToReplace[var9], this.textToReplaceWith[var9]);
            }
         }

         return var5;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(ZI)Z",
      garbageValue = "1135958136"
   )
   public final boolean method5064(boolean var1) {
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

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(ZI)Ldj;",
      garbageValue = "-1197043790"
   )
   public final ModelData method5066(boolean var1) {
      int var2 = this.maleHeadModel;
      int var3 = this.maleHeadModel2;
      if(var1) {
         var2 = this.femaleHeadModel;
         var3 = this.femaleHeadModel2;
      }

      if(var2 == -1) {
         return null;
      } else {
         ModelData var4 = ModelData.method2583(ItemDefinition_modelIndexCache, var2, 0);
         if(var3 != -1) {
            ModelData var5 = ModelData.method2583(ItemDefinition_modelIndexCache, var3, 0);
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
               var4.method2660(this.textureToReplace[var7], this.textToReplaceWith[var7]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-417413109"
   )
   public int method5067(int var1, int var2) {
      return class23.method190(this.field3683, var1, var2);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "1778511748"
   )
   public String method5068(int var1, String var2) {
      return class155.method3172(this.field3683, var1, var2);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "2048414108"
   )
   @Export("getShiftClickActionIndex")
   public int getShiftClickActionIndex() {
      return this.team != -1 && this.inventoryActions != null?(this.team >= 0?(this.inventoryActions[this.team] != null?this.team:-1):("Drop".equalsIgnoreCase(this.inventoryActions[4])?4:-1)):-1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Lgp;Ljava/lang/String;I)I",
      garbageValue = "-299280627"
   )
   public static int method5113(Buffer var0, String var1) {
      int var2 = var0.offset;
      int var4 = var1.length();
      byte[] var5 = new byte[var4];

      for(int var6 = 0; var6 < var4; ++var6) {
         char var7 = var1.charAt(var6);
         if(var7 > 0 && var7 < 128 || var7 >= 160 && var7 <= 255) {
            var5[var6] = (byte)var7;
         } else if(var7 == 8364) {
            var5[var6] = -128;
         } else if(var7 == 8218) {
            var5[var6] = -126;
         } else if(var7 == 402) {
            var5[var6] = -125;
         } else if(var7 == 8222) {
            var5[var6] = -124;
         } else if(var7 == 8230) {
            var5[var6] = -123;
         } else if(var7 == 8224) {
            var5[var6] = -122;
         } else if(var7 == 8225) {
            var5[var6] = -121;
         } else if(var7 == 710) {
            var5[var6] = -120;
         } else if(var7 == 8240) {
            var5[var6] = -119;
         } else if(var7 == 352) {
            var5[var6] = -118;
         } else if(var7 == 8249) {
            var5[var6] = -117;
         } else if(var7 == 338) {
            var5[var6] = -116;
         } else if(var7 == 381) {
            var5[var6] = -114;
         } else if(var7 == 8216) {
            var5[var6] = -111;
         } else if(var7 == 8217) {
            var5[var6] = -110;
         } else if(var7 == 8220) {
            var5[var6] = -109;
         } else if(var7 == 8221) {
            var5[var6] = -108;
         } else if(var7 == 8226) {
            var5[var6] = -107;
         } else if(var7 == 8211) {
            var5[var6] = -106;
         } else if(var7 == 8212) {
            var5[var6] = -105;
         } else if(var7 == 732) {
            var5[var6] = -104;
         } else if(var7 == 8482) {
            var5[var6] = -103;
         } else if(var7 == 353) {
            var5[var6] = -102;
         } else if(var7 == 8250) {
            var5[var6] = -101;
         } else if(var7 == 339) {
            var5[var6] = -100;
         } else if(var7 == 382) {
            var5[var6] = -98;
         } else if(var7 == 376) {
            var5[var6] = -97;
         } else {
            var5[var6] = 63;
         }
      }

      var0.putShortSmart(var5.length);
      var0.offset += class313.huffman.compress(var5, 0, var5.length, var0.payload, var0.offset);
      return var0.offset - var2;
   }
}
