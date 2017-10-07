import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("io")
@Implements("ItemComposition")
public class ItemComposition extends CacheableNode {
   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   @Export("items")
   public static NodeCache items;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   @Export("itemModelCache")
   public static NodeCache itemModelCache;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lgl;"
   )
   @Export("itemSpriteCache")
   public static NodeCache itemSpriteCache;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lju;"
   )
   public static Font field3488;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -1015134405
   )
   @Export("maleHeadModel")
   int maleHeadModel;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -81693117
   )
   @Export("maleModel")
   int maleModel;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -351524477
   )
   @Export("inventoryModel")
   int inventoryModel;
   @ObfuscatedName("aw")
   @Export("countObj")
   int[] countObj;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -332541273
   )
   @Export("team")
   int team;
   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "Lgc;"
   )
   IterableHashTable field3494;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 2144072671
   )
   @Export("maleHeadModel2")
   int maleHeadModel2;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -1533814699
   )
   @Export("maleModel1")
   int maleModel1;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -1815654259
   )
   @Export("maleModel2")
   int maleModel2;
   @ObfuscatedName("ad")
   @Export("inventoryActions")
   public String[] inventoryActions;
   @ObfuscatedName("f")
   @Export("name")
   public String name;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -894614181
   )
   @Export("femaleHeadModel")
   int femaleHeadModel;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 842153837
   )
   @Export("zoom2d")
   public int zoom2d;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 956581457
   )
   @Export("id")
   public int id;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -1955005475
   )
   @Export("femaleHeadModel2")
   int femaleHeadModel2;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 248423141
   )
   @Export("femaleModel")
   int femaleModel;
   @ObfuscatedName("ax")
   @Export("countCo")
   int[] countCo;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -861371403
   )
   @Export("femaleModel1")
   int femaleModel1;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -509655837
   )
   @Export("femaleModel2")
   int femaleModel2;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -2002565623
   )
   @Export("xan2d")
   public int xan2d;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 2037568817
   )
   @Export("resizeX")
   int resizeX;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1095492025
   )
   @Export("yan2d")
   public int yan2d;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -1597727121
   )
   @Export("isStackable")
   public int isStackable;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 704687611
   )
   @Export("offsetX2d")
   public int offsetX2d;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 1256774637
   )
   @Export("resizeY")
   int resizeY;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -77713911
   )
   @Export("offsetY2d")
   public int offsetY2d;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 833728087
   )
   @Export("zan2d")
   public int zan2d;
   @ObfuscatedName("ah")
   @Export("isMembers")
   public boolean isMembers;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -1337001535
   )
   @Export("price")
   public int price;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 1328471487
   )
   @Export("resizeZ")
   int resizeZ;
   @ObfuscatedName("j")
   @Export("colourToReplace")
   short[] colourToReplace;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 1327594651
   )
   @Export("maleOffset")
   int maleOffset;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -1198582527
   )
   @Export("notedTemplate")
   public int notedTemplate;
   @ObfuscatedName("ab")
   @Export("groundActions")
   public String[] groundActions;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -296223671
   )
   @Export("femaleOffset")
   int femaleOffset;
   @ObfuscatedName("by")
   public boolean field3538;
   @ObfuscatedName("c")
   @Export("textureToReplace")
   short[] textureToReplace;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -2058393107
   )
   @Export("note")
   public int note;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = 753006603
   )
   @Export("ambient")
   public int ambient;
   @ObfuscatedName("x")
   @Export("colourToReplaceWith")
   short[] colourToReplaceWith;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = 1312847445
   )
   @Export("notedId")
   int notedId;
   @ObfuscatedName("h")
   @Export("textToReplaceWith")
   short[] textToReplaceWith;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = 1230171979
   )
   @Export("contrast")
   public int contrast;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = -1932294395
   )
   public int field3526;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = -578627899
   )
   public int field3542;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = -111848075
   )
   @Export("unnotedId")
   int unnotedId;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = 1200271851
   )
   public int field3541;

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
      this.field3526 = 0;
      this.field3538 = false;
      this.unnotedId = -1;
      this.notedId = -1;
      this.field3541 = -1;
      this.field3542 = -1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lfg;II)V",
      garbageValue = "697450802"
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
            this.field3538 = true;
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
            this.field3526 = var1.readUnsignedByte();
         } else if(var2 == 139) {
            this.unnotedId = var1.readUnsignedShort();
         } else if(var2 == 140) {
            this.notedId = var1.readUnsignedShort();
         } else if(var2 == 148) {
            this.field3541 = var1.readUnsignedShort();
         } else if(var2 == 149) {
            this.field3542 = var1.readUnsignedShort();
         } else if(var2 == 249) {
            this.field3494 = class41.method590(var1, this.field3494);
         }
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)Leb;",
      garbageValue = "-814018489"
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
            return class46.getItemDefinition(var2).getModel(1);
         }
      }

      Model var5 = (Model)itemModelCache.get((long)this.id);
      if(var5 != null) {
         return var5;
      } else {
         ModelData var6 = ModelData.method2498(class89.field1406, this.inventoryModel, 0);
         if(var6 == null) {
            return null;
         } else {
            if(this.resizeX != 128 || this.resizeY != 128 || this.resizeZ != 128) {
               var6.method2515(this.resizeX, this.resizeY, this.resizeZ);
            }

            int var4;
            if(this.colourToReplace != null) {
               for(var4 = 0; var4 < this.colourToReplace.length; ++var4) {
                  var6.recolor(this.colourToReplace[var4], this.colourToReplaceWith[var4]);
               }
            }

            if(this.textureToReplace != null) {
               for(var4 = 0; var4 < this.textureToReplace.length; ++var4) {
                  var6.method2513(this.textureToReplace[var4], this.textToReplaceWith[var4]);
               }
            }

            var5 = var6.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
            var5.field1938 = true;
            itemModelCache.put(var5, (long)this.id);
            return var5;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IB)Ldl;",
      garbageValue = "-55"
   )
   public final ModelData method4712(int var1) {
      int var3;
      if(this.countObj != null && var1 > 1) {
         int var2 = -1;

         for(var3 = 0; var3 < 10; ++var3) {
            if(var1 >= this.countCo[var3] && this.countCo[var3] != 0) {
               var2 = this.countObj[var3];
            }
         }

         if(var2 != -1) {
            return class46.getItemDefinition(var2).method4712(1);
         }
      }

      ModelData var4 = ModelData.method2498(class89.field1406, this.inventoryModel, 0);
      if(var4 == null) {
         return null;
      } else {
         if(this.resizeX != 128 || this.resizeY != 128 || this.resizeZ != 128) {
            var4.method2515(this.resizeX, this.resizeY, this.resizeZ);
         }

         if(this.colourToReplace != null) {
            for(var3 = 0; var3 < this.colourToReplace.length; ++var3) {
               var4.recolor(this.colourToReplace[var3], this.colourToReplaceWith[var3]);
            }
         }

         if(this.textureToReplace != null) {
            for(var3 = 0; var3 < this.textureToReplace.length; ++var3) {
               var4.method2513(this.textureToReplace[var3], this.textToReplaceWith[var3]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "1"
   )
   @Export("post")
   void post() {
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(ZI)Z",
      garbageValue = "-1964209951"
   )
   public final boolean method4687(boolean var1) {
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
         if(!class89.field1406.method4237(var2, 0)) {
            var4 = false;
         }

         if(var3 != -1 && !class89.field1406.method4237(var3, 0)) {
            var4 = false;
         }

         return var4;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Lfg;I)V",
      garbageValue = "-1524508690"
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
      signature = "(ZB)Ldl;",
      garbageValue = "64"
   )
   public final ModelData method4671(boolean var1) {
      int var2 = this.maleHeadModel;
      int var3 = this.maleHeadModel2;
      if(var1) {
         var2 = this.femaleHeadModel;
         var3 = this.femaleHeadModel2;
      }

      if(var2 == -1) {
         return null;
      } else {
         ModelData var4 = ModelData.method2498(class89.field1406, var2, 0);
         if(var3 != -1) {
            ModelData var5 = ModelData.method2498(class89.field1406, var3, 0);
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
               var4.method2513(this.textureToReplace[var7], this.textToReplaceWith[var7]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(ZI)Z",
      garbageValue = "2009340287"
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
         if(!class89.field1406.method4237(var2, 0)) {
            var5 = false;
         }

         if(var3 != -1 && !class89.field1406.method4237(var3, 0)) {
            var5 = false;
         }

         if(var4 != -1 && !class89.field1406.method4237(var4, 0)) {
            var5 = false;
         }

         return var5;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ZB)Ldl;",
      garbageValue = "-24"
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
         ModelData var5 = ModelData.method2498(class89.field1406, var2, 0);
         if(var3 != -1) {
            ModelData var6 = ModelData.method2498(class89.field1406, var3, 0);
            if(var4 != -1) {
               ModelData var7 = ModelData.method2498(class89.field1406, var4, 0);
               ModelData[] var8 = new ModelData[]{var5, var6, var7};
               var5 = new ModelData(var8, 3);
            } else {
               ModelData[] var10 = new ModelData[]{var5, var6};
               var5 = new ModelData(var10, 2);
            }
         }

         if(!var1 && this.maleOffset != 0) {
            var5.method2511(0, this.maleOffset, 0);
         }

         if(var1 && this.femaleOffset != 0) {
            var5.method2511(0, this.femaleOffset, 0);
         }

         int var9;
         if(this.colourToReplace != null) {
            for(var9 = 0; var9 < this.colourToReplace.length; ++var9) {
               var5.recolor(this.colourToReplace[var9], this.colourToReplaceWith[var9]);
            }
         }

         if(this.textureToReplace != null) {
            for(var9 = 0; var9 < this.textureToReplace.length; ++var9) {
               var5.method2513(this.textureToReplace[var9], this.textToReplaceWith[var9]);
            }
         }

         return var5;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lio;Lio;I)V",
      garbageValue = "-428026809"
   )
   void method4676(ItemComposition var1, ItemComposition var2) {
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

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(Lio;Lio;B)V",
      garbageValue = "126"
   )
   void method4664(ItemComposition var1, ItemComposition var2) {
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
      this.field3526 = var2.field3526;
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

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lio;Lio;I)V",
      garbageValue = "675024586"
   )
   void method4661(ItemComposition var1, ItemComposition var2) {
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
      this.field3538 = false;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(IB)Lio;",
      garbageValue = "113"
   )
   public ItemComposition method4714(int var1) {
      if(this.countObj != null && var1 > 1) {
         int var2 = -1;

         for(int var3 = 0; var3 < 10; ++var3) {
            if(var1 >= this.countCo[var3] && this.countCo[var3] != 0) {
               var2 = this.countObj[var3];
            }
         }

         if(var2 != -1) {
            return class46.getItemDefinition(var2);
         }
      }

      return this;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1295366239"
   )
   public int method4675() {
      return this.team != -1 && this.inventoryActions != null?(this.team >= 0?(this.inventoryActions[this.team] != null?this.team:-1):("Drop".equalsIgnoreCase(this.inventoryActions[4])?4:-1)):-1;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "872302016"
   )
   public int method4667(int var1, int var2) {
      return FileSystem.method4214(this.field3494, var1, var2);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;B)Ljava/lang/String;",
      garbageValue = "75"
   )
   public String method4674(int var1, String var2) {
      return class85.method1769(this.field3494, var1, var2);
   }
}
