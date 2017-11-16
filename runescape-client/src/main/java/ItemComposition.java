import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jj")
@Implements("ItemComposition")
public class ItemComposition extends CacheableNode {
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   @Export("item_ref")
   static IndexDataBase item_ref;
   @ObfuscatedName("t")
   @Export("isMembersWorld")
   public static boolean isMembersWorld;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   @Export("items")
   public static NodeCache items;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   @Export("itemModelCache")
   public static NodeCache itemModelCache;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   @Export("itemSpriteCache")
   public static NodeCache itemSpriteCache;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 3158213
   )
   @Export("id")
   public int id;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 1990943773
   )
   @Export("inventoryModel")
   int inventoryModel;
   @ObfuscatedName("m")
   @Export("name")
   public String name;
   @ObfuscatedName("h")
   @Export("colourToReplace")
   short[] colourToReplace;
   @ObfuscatedName("c")
   @Export("colourToReplaceWith")
   short[] colourToReplaceWith;
   @ObfuscatedName("y")
   @Export("textureToReplace")
   short[] textureToReplace;
   @ObfuscatedName("p")
   @Export("textToReplaceWith")
   short[] textToReplaceWith;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 571424453
   )
   @Export("zoom2d")
   public int zoom2d;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1515125995
   )
   @Export("xan2d")
   public int xan2d;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 788926331
   )
   @Export("yan2d")
   public int yan2d;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 2084664607
   )
   @Export("zan2d")
   public int zan2d;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 381071123
   )
   @Export("offsetX2d")
   public int offsetX2d;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1633060257
   )
   @Export("offsetY2d")
   public int offsetY2d;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 1777074323
   )
   @Export("isStackable")
   public int isStackable;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -1013842331
   )
   @Export("price")
   public int price;
   @ObfuscatedName("ae")
   @Export("isMembers")
   public boolean isMembers;
   @ObfuscatedName("ak")
   @Export("groundActions")
   public String[] groundActions;
   @ObfuscatedName("aq")
   @Export("inventoryActions")
   public String[] inventoryActions;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -1927575925
   )
   @Export("team")
   int team;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -1457481945
   )
   @Export("maleModel")
   int maleModel;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -636036649
   )
   @Export("maleModel1")
   int maleModel1;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 339258079
   )
   @Export("maleOffset")
   int maleOffset;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -659680627
   )
   @Export("femaleModel")
   int femaleModel;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 1936485371
   )
   @Export("femaleModel1")
   int femaleModel1;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -1733320929
   )
   @Export("femaleOffset")
   int femaleOffset;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -1296488375
   )
   @Export("maleModel2")
   int maleModel2;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 1204947107
   )
   @Export("femaleModel2")
   int femaleModel2;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -768805447
   )
   @Export("maleHeadModel")
   int maleHeadModel;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -1121754011
   )
   @Export("maleHeadModel2")
   int maleHeadModel2;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 822187711
   )
   @Export("femaleHeadModel")
   int femaleHeadModel;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -979186911
   )
   @Export("femaleHeadModel2")
   int femaleHeadModel2;
   @ObfuscatedName("ay")
   @Export("countObj")
   int[] countObj;
   @ObfuscatedName("ab")
   @Export("countCo")
   int[] countCo;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 1894099451
   )
   @Export("note")
   public int note;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -732638027
   )
   @Export("notedTemplate")
   public int notedTemplate;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -1630445567
   )
   @Export("resizeX")
   int resizeX;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -1870089027
   )
   @Export("resizeY")
   int resizeY;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -1132510971
   )
   @Export("resizeZ")
   int resizeZ;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = 847388811
   )
   @Export("ambient")
   public int ambient;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = -1353796061
   )
   @Export("contrast")
   public int contrast;
   @ObfuscatedName("bq")
   @ObfuscatedGetter(
      intValue = -1279374049
   )
   public int field3587;
   @ObfuscatedName("bc")
   @ObfuscatedSignature(
      signature = "Lgu;"
   )
   IterableHashTable field3593;
   @ObfuscatedName("bb")
   public boolean field3589;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = -1222379085
   )
   @Export("unnotedId")
   int unnotedId;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = -307102629
   )
   @Export("notedId")
   int notedId;
   @ObfuscatedName("be")
   @ObfuscatedGetter(
      intValue = 504422673
   )
   public int field3592;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = 145950333
   )
   public int field3558;

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
      this.field3587 = 0;
      this.field3589 = false;
      this.unnotedId = -1;
      this.notedId = -1;
      this.field3592 = -1;
      this.field3558 = -1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-43"
   )
   @Export("post")
   void post() {
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lfs;I)V",
      garbageValue = "2067547294"
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
      signature = "(Lfs;II)V",
      garbageValue = "1087412745"
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
            this.field3589 = true;
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
            this.field3587 = var1.readUnsignedByte();
         } else if(var2 == 139) {
            this.unnotedId = var1.readUnsignedShort();
         } else if(var2 == 140) {
            this.notedId = var1.readUnsignedShort();
         } else if(var2 == 148) {
            this.field3592 = var1.readUnsignedShort();
         } else if(var2 == 149) {
            this.field3558 = var1.readUnsignedShort();
         } else if(var2 == 249) {
            this.field3593 = class27.method203(var1, this.field3593);
         }
      }

   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(Ljj;Ljj;I)V",
      garbageValue = "1830265606"
   )
   void method4572(ItemComposition var1, ItemComposition var2) {
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

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljj;Ljj;I)V",
      garbageValue = "40328102"
   )
   void method4573(ItemComposition var1, ItemComposition var2) {
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
      this.field3587 = var2.field3587;
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
      signature = "(Ljj;Ljj;B)V",
      garbageValue = "38"
   )
   void method4574(ItemComposition var1, ItemComposition var2) {
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
      this.field3589 = false;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)Lda;",
      garbageValue = "-205796937"
   )
   public final ModelData method4575(int var1) {
      int var3;
      if(this.countObj != null && var1 > 1) {
         int var2 = -1;

         for(var3 = 0; var3 < 10; ++var3) {
            if(var1 >= this.countCo[var3] && this.countCo[var3] != 0) {
               var2 = this.countObj[var3];
            }
         }

         if(var2 != -1) {
            return class139.getItemDefinition(var2).method4575(1);
         }
      }

      ModelData var4 = ModelData.method2419(class256.field3427, this.inventoryModel, 0);
      if(var4 == null) {
         return null;
      } else {
         if(this.resizeX != 128 || this.resizeY != 128 || this.resizeZ != 128) {
            var4.method2442(this.resizeX, this.resizeY, this.resizeZ);
         }

         if(this.colourToReplace != null) {
            for(var3 = 0; var3 < this.colourToReplace.length; ++var3) {
               var4.recolor(this.colourToReplace[var3], this.colourToReplaceWith[var3]);
            }
         }

         if(this.textureToReplace != null) {
            for(var3 = 0; var3 < this.textureToReplace.length; ++var3) {
               var4.method2432(this.textureToReplace[var3], this.textToReplaceWith[var3]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)Lev;",
      garbageValue = "-1696709673"
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
            return class139.getItemDefinition(var2).getModel(1);
         }
      }

      Model var5 = (Model)itemModelCache.get((long)this.id);
      if(var5 != null) {
         return var5;
      } else {
         ModelData var6 = ModelData.method2419(class256.field3427, this.inventoryModel, 0);
         if(var6 == null) {
            return null;
         } else {
            if(this.resizeX != 128 || this.resizeY != 128 || this.resizeZ != 128) {
               var6.method2442(this.resizeX, this.resizeY, this.resizeZ);
            }

            int var4;
            if(this.colourToReplace != null) {
               for(var4 = 0; var4 < this.colourToReplace.length; ++var4) {
                  var6.recolor(this.colourToReplace[var4], this.colourToReplaceWith[var4]);
               }
            }

            if(this.textureToReplace != null) {
               for(var4 = 0; var4 < this.textureToReplace.length; ++var4) {
                  var6.method2432(this.textureToReplace[var4], this.textToReplaceWith[var4]);
               }
            }

            var5 = var6.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
            var5.field1831 = true;
            itemModelCache.put(var5, (long)this.id);
            return var5;
         }
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(II)Ljj;",
      garbageValue = "1553609698"
   )
   public ItemComposition method4597(int var1) {
      if(this.countObj != null && var1 > 1) {
         int var2 = -1;

         for(int var3 = 0; var3 < 10; ++var3) {
            if(var1 >= this.countCo[var3] && this.countCo[var3] != 0) {
               var2 = this.countObj[var3];
            }
         }

         if(var2 != -1) {
            return class139.getItemDefinition(var2);
         }
      }

      return this;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(ZI)Z",
      garbageValue = "-621529943"
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
         if(!class256.field3427.method4157(var2, 0)) {
            var5 = false;
         }

         if(var3 != -1 && !class256.field3427.method4157(var3, 0)) {
            var5 = false;
         }

         if(var4 != -1 && !class256.field3427.method4157(var4, 0)) {
            var5 = false;
         }

         return var5;
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(ZI)Lda;",
      garbageValue = "642189397"
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
         ModelData var5 = ModelData.method2419(class256.field3427, var2, 0);
         if(var3 != -1) {
            ModelData var6 = ModelData.method2419(class256.field3427, var3, 0);
            if(var4 != -1) {
               ModelData var7 = ModelData.method2419(class256.field3427, var4, 0);
               ModelData[] var8 = new ModelData[]{var5, var6, var7};
               var5 = new ModelData(var8, 3);
            } else {
               ModelData[] var10 = new ModelData[]{var5, var6};
               var5 = new ModelData(var10, 2);
            }
         }

         if(!var1 && this.maleOffset != 0) {
            var5.method2458(0, this.maleOffset, 0);
         }

         if(var1 && this.femaleOffset != 0) {
            var5.method2458(0, this.femaleOffset, 0);
         }

         int var9;
         if(this.colourToReplace != null) {
            for(var9 = 0; var9 < this.colourToReplace.length; ++var9) {
               var5.recolor(this.colourToReplace[var9], this.colourToReplaceWith[var9]);
            }
         }

         if(this.textureToReplace != null) {
            for(var9 = 0; var9 < this.textureToReplace.length; ++var9) {
               var5.method2432(this.textureToReplace[var9], this.textToReplaceWith[var9]);
            }
         }

         return var5;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(ZI)Z",
      garbageValue = "1783164683"
   )
   public final boolean method4580(boolean var1) {
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
         if(!class256.field3427.method4157(var2, 0)) {
            var4 = false;
         }

         if(var3 != -1 && !class256.field3427.method4157(var3, 0)) {
            var4 = false;
         }

         return var4;
      }
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(ZI)Lda;",
      garbageValue = "600702092"
   )
   public final ModelData method4581(boolean var1) {
      int var2 = this.maleHeadModel;
      int var3 = this.maleHeadModel2;
      if(var1) {
         var2 = this.femaleHeadModel;
         var3 = this.femaleHeadModel2;
      }

      if(var2 == -1) {
         return null;
      } else {
         ModelData var4 = ModelData.method2419(class256.field3427, var2, 0);
         if(var3 != -1) {
            ModelData var5 = ModelData.method2419(class256.field3427, var3, 0);
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
               var4.method2432(this.textureToReplace[var7], this.textToReplaceWith[var7]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1949255036"
   )
   public int method4610(int var1, int var2) {
      return CombatInfo2.method4400(this.field3593, var1, var2);
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-1346442208"
   )
   public String method4577(int var1, String var2) {
      return ChatLineBuffer.method1852(this.field3593, var1, var2);
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1492216426"
   )
   public int method4584() {
      return this.team != -1 && this.inventoryActions != null?(this.team >= 0?(this.inventoryActions[this.team] != null?this.team:-1):("Drop".equalsIgnoreCase(this.inventoryActions[4])?4:-1)):-1;
   }
}
