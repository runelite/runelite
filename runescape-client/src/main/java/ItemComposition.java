import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jx")
@Implements("ItemComposition")
public class ItemComposition extends CacheableNode {
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   @Export("item_ref")
   public static IndexDataBase item_ref;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lik;"
   )
   public static IndexDataBase field3538;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1670798073
   )
   public static int field3543;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   @Export("items")
   static NodeCache items;
   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   @Export("itemModelCache")
   static NodeCache itemModelCache;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lgr;"
   )
   @Export("itemSpriteCache")
   public static NodeCache itemSpriteCache;
   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "Ljt;"
   )
   public static Font field3547;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 910584741
   )
   @Export("id")
   public int id;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 539011591
   )
   @Export("inventoryModel")
   int inventoryModel;
   @ObfuscatedName("t")
   @Export("name")
   public String name;
   @ObfuscatedName("h")
   @Export("colourToReplace")
   short[] colourToReplace;
   @ObfuscatedName("u")
   @Export("colourToReplaceWith")
   short[] colourToReplaceWith;
   @ObfuscatedName("r")
   @Export("textureToReplace")
   short[] textureToReplace;
   @ObfuscatedName("g")
   @Export("textToReplaceWith")
   short[] textToReplaceWith;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1546748197
   )
   @Export("zoom2d")
   public int zoom2d;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -897610891
   )
   @Export("xan2d")
   public int xan2d;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1289624397
   )
   @Export("yan2d")
   public int yan2d;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 969339817
   )
   @Export("zan2d")
   public int zan2d;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -550780417
   )
   @Export("offsetX2d")
   public int offsetX2d;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -1879177597
   )
   @Export("offsetY2d")
   public int offsetY2d;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = -521097773
   )
   @Export("isStackable")
   public int isStackable;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 1651038299
   )
   @Export("price")
   public int price;
   @ObfuscatedName("aq")
   @Export("isMembers")
   public boolean isMembers;
   @ObfuscatedName("ab")
   @Export("groundActions")
   public String[] groundActions;
   @ObfuscatedName("as")
   @Export("inventoryActions")
   public String[] inventoryActions;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -1572941133
   )
   @Export("team")
   int team;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -86773367
   )
   @Export("maleModel")
   int maleModel;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 997339145
   )
   @Export("maleModel1")
   int maleModel1;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -1184960861
   )
   @Export("maleOffset")
   int maleOffset;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -1985322345
   )
   @Export("femaleModel")
   int femaleModel;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 1323182949
   )
   @Export("femaleModel1")
   int femaleModel1;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -919500475
   )
   @Export("femaleOffset")
   int femaleOffset;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -1070937019
   )
   @Export("maleModel2")
   int maleModel2;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -1629182641
   )
   @Export("femaleModel2")
   int femaleModel2;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -2044387301
   )
   @Export("maleHeadModel")
   int maleHeadModel;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 971864495
   )
   @Export("maleHeadModel2")
   int maleHeadModel2;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -1438414101
   )
   @Export("femaleHeadModel")
   int femaleHeadModel;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 227797427
   )
   @Export("femaleHeadModel2")
   int femaleHeadModel2;
   @ObfuscatedName("ax")
   @Export("countObj")
   int[] countObj;
   @ObfuscatedName("af")
   @Export("countCo")
   int[] countCo;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -1375939979
   )
   @Export("note")
   public int note;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 1037751167
   )
   @Export("notedTemplate")
   public int notedTemplate;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -267769621
   )
   @Export("resizeX")
   int resizeX;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 360227849
   )
   @Export("resizeY")
   int resizeY;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 1020106357
   )
   @Export("resizeZ")
   int resizeZ;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = -1203293271
   )
   @Export("ambient")
   public int ambient;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = 1815476801
   )
   @Export("contrast")
   public int contrast;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = -224288865
   )
   public int field3588;
   @ObfuscatedName("bl")
   @ObfuscatedSignature(
      signature = "Lgd;"
   )
   IterableHashTable field3576;
   @ObfuscatedName("bw")
   public boolean field3590;
   @ObfuscatedName("bj")
   @ObfuscatedGetter(
      intValue = 970830405
   )
   @Export("unnotedId")
   int unnotedId;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = -2136400467
   )
   @Export("notedId")
   int notedId;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = 642204199
   )
   public int field3593;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = -1065065461
   )
   public int field3594;

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
      this.field3588 = 0;
      this.field3590 = false;
      this.unnotedId = -1;
      this.notedId = -1;
      this.field3593 = -1;
      this.field3594 = -1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "749250554"
   )
   @Export("post")
   void post() {
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lfv;I)V",
      garbageValue = "-602049960"
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
      signature = "(Lfv;IB)V",
      garbageValue = "1"
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
            this.field3590 = true;
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
            this.field3588 = var1.readUnsignedByte();
         } else if(var2 == 139) {
            this.unnotedId = var1.readUnsignedShort();
         } else if(var2 == 140) {
            this.notedId = var1.readUnsignedShort();
         } else if(var2 == 148) {
            this.field3593 = var1.readUnsignedShort();
         } else if(var2 == 149) {
            this.field3594 = var1.readUnsignedShort();
         } else if(var2 == 249) {
            this.field3576 = Tile.method2607(var1, this.field3576);
         }
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Ljx;Ljx;B)V",
      garbageValue = "-109"
   )
   void method4753(ItemComposition var1, ItemComposition var2) {
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
      signature = "(Ljx;Ljx;I)V",
      garbageValue = "1263524573"
   )
   void method4752(ItemComposition var1, ItemComposition var2) {
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
      this.field3588 = var2.field3588;
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
      signature = "(Ljx;Ljx;B)V",
      garbageValue = "116"
   )
   void method4784(ItemComposition var1, ItemComposition var2) {
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
      this.field3590 = false;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(IS)Ldv;",
      garbageValue = "16368"
   )
   public final ModelData method4754(int var1) {
      int var3;
      if(this.countObj != null && var1 > 1) {
         int var2 = -1;

         for(var3 = 0; var3 < 10; ++var3) {
            if(var1 >= this.countCo[var3] && this.countCo[var3] != 0) {
               var2 = this.countObj[var3];
            }
         }

         if(var2 != -1) {
            return class250.getItemDefinition(var2).method4754(1);
         }
      }

      ModelData var4 = ModelData.method2533(field3538, this.inventoryModel, 0);
      if(var4 == null) {
         return null;
      } else {
         if(this.resizeX != 128 || this.resizeY != 128 || this.resizeZ != 128) {
            var4.method2587(this.resizeX, this.resizeY, this.resizeZ);
         }

         if(this.colourToReplace != null) {
            for(var3 = 0; var3 < this.colourToReplace.length; ++var3) {
               var4.recolor(this.colourToReplace[var3], this.colourToReplaceWith[var3]);
            }
         }

         if(this.textureToReplace != null) {
            for(var3 = 0; var3 < this.textureToReplace.length; ++var3) {
               var4.method2536(this.textureToReplace[var3], this.textToReplaceWith[var3]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(II)Len;",
      garbageValue = "1521456058"
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
            return class250.getItemDefinition(var2).getModel(1);
         }
      }

      Model var5 = (Model)itemModelCache.get((long)this.id);
      if(var5 != null) {
         return var5;
      } else {
         ModelData var6 = ModelData.method2533(field3538, this.inventoryModel, 0);
         if(var6 == null) {
            return null;
         } else {
            if(this.resizeX != 128 || this.resizeY != 128 || this.resizeZ != 128) {
               var6.method2587(this.resizeX, this.resizeY, this.resizeZ);
            }

            int var4;
            if(this.colourToReplace != null) {
               for(var4 = 0; var4 < this.colourToReplace.length; ++var4) {
                  var6.recolor(this.colourToReplace[var4], this.colourToReplaceWith[var4]);
               }
            }

            if(this.textureToReplace != null) {
               for(var4 = 0; var4 < this.textureToReplace.length; ++var4) {
                  var6.method2536(this.textureToReplace[var4], this.textToReplaceWith[var4]);
               }
            }

            var5 = var6.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
            var5.field1860 = true;
            itemModelCache.put(var5, (long)this.id);
            return var5;
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(II)Ljx;",
      garbageValue = "-1103925308"
   )
   public ItemComposition method4756(int var1) {
      if(this.countObj != null && var1 > 1) {
         int var2 = -1;

         for(int var3 = 0; var3 < 10; ++var3) {
            if(var1 >= this.countCo[var3] && this.countCo[var3] != 0) {
               var2 = this.countObj[var3];
            }
         }

         if(var2 != -1) {
            return class250.getItemDefinition(var2);
         }
      }

      return this;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(ZB)Z",
      garbageValue = "-117"
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
         if(!field3538.method4281(var2, 0)) {
            var5 = false;
         }

         if(var3 != -1 && !field3538.method4281(var3, 0)) {
            var5 = false;
         }

         if(var4 != -1 && !field3538.method4281(var4, 0)) {
            var5 = false;
         }

         return var5;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(ZB)Ldv;",
      garbageValue = "-9"
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
         ModelData var5 = ModelData.method2533(field3538, var2, 0);
         if(var3 != -1) {
            ModelData var6 = ModelData.method2533(field3538, var3, 0);
            if(var4 != -1) {
               ModelData var7 = ModelData.method2533(field3538, var4, 0);
               ModelData[] var8 = new ModelData[]{var5, var6, var7};
               var5 = new ModelData(var8, 3);
            } else {
               ModelData[] var10 = new ModelData[]{var5, var6};
               var5 = new ModelData(var10, 2);
            }
         }

         if(!var1 && this.maleOffset != 0) {
            var5.method2576(0, this.maleOffset, 0);
         }

         if(var1 && this.femaleOffset != 0) {
            var5.method2576(0, this.femaleOffset, 0);
         }

         int var9;
         if(this.colourToReplace != null) {
            for(var9 = 0; var9 < this.colourToReplace.length; ++var9) {
               var5.recolor(this.colourToReplace[var9], this.colourToReplaceWith[var9]);
            }
         }

         if(this.textureToReplace != null) {
            for(var9 = 0; var9 < this.textureToReplace.length; ++var9) {
               var5.method2536(this.textureToReplace[var9], this.textToReplaceWith[var9]);
            }
         }

         return var5;
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ZS)Z",
      garbageValue = "7345"
   )
   public final boolean method4759(boolean var1) {
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
         if(!field3538.method4281(var2, 0)) {
            var4 = false;
         }

         if(var3 != -1 && !field3538.method4281(var3, 0)) {
            var4 = false;
         }

         return var4;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(ZB)Ldv;",
      garbageValue = "-70"
   )
   public final ModelData method4791(boolean var1) {
      int var2 = this.maleHeadModel;
      int var3 = this.maleHeadModel2;
      if(var1) {
         var2 = this.femaleHeadModel;
         var3 = this.femaleHeadModel2;
      }

      if(var2 == -1) {
         return null;
      } else {
         ModelData var4 = ModelData.method2533(field3538, var2, 0);
         if(var3 != -1) {
            ModelData var5 = ModelData.method2533(field3538, var3, 0);
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
               var4.method2536(this.textureToReplace[var7], this.textToReplaceWith[var7]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1117948751"
   )
   public int method4760(int var1, int var2) {
      return Occluder.method2998(this.field3576, var1, var2);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-2074751032"
   )
   public String method4761(int var1, String var2) {
      return VertexNormal.method2702(this.field3576, var1, var2);
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1433019527"
   )
   public int method4762() {
      return this.team != -1 && this.inventoryActions != null?(this.team >= 0?(this.inventoryActions[this.team] != null?this.team:-1):("Drop".equalsIgnoreCase(this.inventoryActions[4])?4:-1)):-1;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)Lcd;",
      garbageValue = "1200293894"
   )
   static World method4799() {
      return World.field1216 < World.worldCount?Coordinates.worldList[++World.field1216 - 1]:null;
   }
}
