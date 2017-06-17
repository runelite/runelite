import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("iy")
@Implements("ItemComposition")
public class ItemComposition extends CacheableNode {
   @ObfuscatedName("ap")
   @Export("inventoryActions")
   public String[] inventoryActions;
   @ObfuscatedName("r")
   @Export("textureToReplace")
   short[] textureToReplace;
   @ObfuscatedName("c")
   public static NodeCache field3497;
   @ObfuscatedName("o")
   @Export("itemModelCache")
   public static NodeCache itemModelCache;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -2031037009
   )
   @Export("resizeX")
   int resizeX;
   @ObfuscatedName("ae")
   @Export("groundActions")
   public String[] groundActions;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -1615743599
   )
   @Export("isStackable")
   public int isStackable;
   @ObfuscatedName("s")
   @Export("colourToReplace")
   short[] colourToReplace;
   @ObfuscatedName("k")
   @Export("colourToReplaceWith")
   short[] colourToReplaceWith;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -362878323
   )
   @Export("maleModel")
   int maleModel;
   @ObfuscatedName("l")
   @Export("textToReplaceWith")
   short[] textToReplaceWith;
   @ObfuscatedName("bv")
   class186 field3507;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1053904847
   )
   @Export("xan2d")
   public int xan2d;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -196130359
   )
   @Export("yan2d")
   public int yan2d;
   @ObfuscatedName("af")
   @Export("isMembers")
   public boolean isMembers;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -573895339
   )
   @Export("zoom2d")
   public int zoom2d;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -1030185785
   )
   @Export("offsetY2d")
   public int offsetY2d;
   @ObfuscatedName("bz")
   public boolean field3513;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 729569145
   )
   @Export("price")
   public int price;
   @ObfuscatedName("q")
   @Export("itemSpriteCache")
   public static NodeCache itemSpriteCache;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -554781573
   )
   @Export("offsetX2d")
   public int offsetX2d;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1620386823
   )
   @Export("inventoryModel")
   int inventoryModel;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 461171657
   )
   @Export("team")
   int team;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 2041411391
   )
   @Export("maleModel1")
   int maleModel1;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 976468065
   )
   @Export("id")
   public int id;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -933915067
   )
   @Export("maleOffset")
   int maleOffset;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 1527887373
   )
   @Export("femaleModel")
   int femaleModel;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -723159627
   )
   @Export("femaleModel1")
   int femaleModel1;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -401393985
   )
   @Export("femaleOffset")
   int femaleOffset;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -435521095
   )
   @Export("maleModel2")
   int maleModel2;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -59889059
   )
   @Export("femaleModel2")
   int femaleModel2;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -1903325001
   )
   @Export("maleHeadModel")
   int maleHeadModel;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 866015973
   )
   @Export("maleHeadModel2")
   int maleHeadModel2;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 1563479547
   )
   @Export("femaleHeadModel")
   int femaleHeadModel;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 1603152887
   )
   @Export("femaleHeadModel2")
   int femaleHeadModel2;
   @ObfuscatedName("az")
   @Export("countObj")
   int[] countObj;
   @ObfuscatedName("ai")
   @Export("countCo")
   int[] countCo;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -1634563983
   )
   @Export("note")
   public int note;
   @ObfuscatedName("v")
   @Export("name")
   public String name;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 675803595
   )
   @Export("resizeY")
   int resizeY;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -1065466363
   )
   @Export("resizeZ")
   int resizeZ;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = -25495167
   )
   @Export("ambient")
   public int ambient;
   @ObfuscatedName("bf")
   @ObfuscatedGetter(
      intValue = 1483965343
   )
   @Export("contrast")
   public int contrast;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = 769607813
   )
   public int field3540;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -1052205525
   )
   @Export("zan2d")
   public int zan2d;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 2014233411
   )
   @Export("notedTemplate")
   public int notedTemplate;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = 1880700591
   )
   int field3543;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = -953488983
   )
   int field3544;
   @ObfuscatedName("bn")
   @ObfuscatedGetter(
      intValue = 1180863639
   )
   public int field3545;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = -664056517
   )
   public int field3546;

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1831817821"
   )
   void method4437() {
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "24"
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

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "-1018169665"
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
            this.field3513 = true;
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
            this.field3540 = var1.readUnsignedByte();
         } else if(var2 == 139) {
            this.field3543 = var1.readUnsignedShort();
         } else if(var2 == 140) {
            this.field3544 = var1.readUnsignedShort();
         } else if(var2 == 148) {
            this.field3545 = var1.readUnsignedShort();
         } else if(var2 == 149) {
            this.field3546 = var1.readUnsignedShort();
         } else if(var2 == 249) {
            this.field3507 = class172.method3016(var1, this.field3507);
         }
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(LItemComposition;LItemComposition;I)V",
      garbageValue = "406205286"
   )
   void method4441(ItemComposition var1, ItemComposition var2) {
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
      this.field3540 = var2.field3540;
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

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(LItemComposition;LItemComposition;I)V",
      garbageValue = "506278977"
   )
   void method4442(ItemComposition var1, ItemComposition var2) {
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

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(II)LModelData;",
      garbageValue = "-2042992658"
   )
   public final ModelData method4445(int var1) {
      int var2;
      if(this.countObj != null && var1 > 1) {
         int var3 = -1;

         for(var2 = 0; var2 < 10; ++var2) {
            if(var1 >= this.countCo[var2] && this.countCo[var2] != 0) {
               var3 = this.countObj[var2];
            }
         }

         if(var3 != -1) {
            return class224.getItemDefinition(var3).method4445(1);
         }
      }

      ModelData var4 = ModelData.method2310(class95.field1485, this.inventoryModel, 0);
      if(var4 == null) {
         return null;
      } else {
         if(this.resizeX != 128 || this.resizeY != 128 || this.resizeZ != 128) {
            var4.method2325(this.resizeX, this.resizeY, this.resizeZ);
         }

         if(this.colourToReplace != null) {
            for(var2 = 0; var2 < this.colourToReplace.length; ++var2) {
               var4.method2322(this.colourToReplace[var2], this.colourToReplaceWith[var2]);
            }
         }

         if(this.textureToReplace != null) {
            for(var2 = 0; var2 < this.textureToReplace.length; ++var2) {
               var4.method2320(this.textureToReplace[var2], this.textToReplaceWith[var2]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(ZI)Z",
      garbageValue = "-136178188"
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
         if(!class95.field1485.method3997(var2, 0)) {
            var5 = false;
         }

         if(var3 != -1 && !class95.field1485.method3997(var3, 0)) {
            var5 = false;
         }

         if(var4 != -1 && !class95.field1485.method3997(var4, 0)) {
            var5 = false;
         }

         return var5;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(ZI)LModelData;",
      garbageValue = "-1145588154"
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
         ModelData var5 = ModelData.method2310(class95.field1485, var2, 0);
         if(var3 != -1) {
            ModelData var6 = ModelData.method2310(class95.field1485, var3, 0);
            if(var4 != -1) {
               ModelData var7 = ModelData.method2310(class95.field1485, var4, 0);
               ModelData[] var8 = new ModelData[]{var5, var6, var7};
               var5 = new ModelData(var8, 3);
            } else {
               ModelData[] var10 = new ModelData[]{var5, var6};
               var5 = new ModelData(var10, 2);
            }
         }

         if(!var1 && this.maleOffset != 0) {
            var5.method2359(0, this.maleOffset, 0);
         }

         if(var1 && this.femaleOffset != 0) {
            var5.method2359(0, this.femaleOffset, 0);
         }

         int var9;
         if(this.colourToReplace != null) {
            for(var9 = 0; var9 < this.colourToReplace.length; ++var9) {
               var5.method2322(this.colourToReplace[var9], this.colourToReplaceWith[var9]);
            }
         }

         if(this.textureToReplace != null) {
            for(var9 = 0; var9 < this.textureToReplace.length; ++var9) {
               var5.method2320(this.textureToReplace[var9], this.textToReplaceWith[var9]);
            }
         }

         return var5;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ZB)Z",
      garbageValue = "0"
   )
   public final boolean method4448(boolean var1) {
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
         if(!class95.field1485.method3997(var2, 0)) {
            var4 = false;
         }

         if(var3 != -1 && !class95.field1485.method3997(var3, 0)) {
            var4 = false;
         }

         return var4;
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(ZI)LModelData;",
      garbageValue = "1695857429"
   )
   public final ModelData method4449(boolean var1) {
      int var2 = this.maleHeadModel;
      int var3 = this.maleHeadModel2;
      if(var1) {
         var2 = this.femaleHeadModel;
         var3 = this.femaleHeadModel2;
      }

      if(var2 == -1) {
         return null;
      } else {
         ModelData var4 = ModelData.method2310(class95.field1485, var2, 0);
         if(var3 != -1) {
            ModelData var5 = ModelData.method2310(class95.field1485, var3, 0);
            ModelData[] var6 = new ModelData[]{var4, var5};
            var4 = new ModelData(var6, 2);
         }

         int var7;
         if(this.colourToReplace != null) {
            for(var7 = 0; var7 < this.colourToReplace.length; ++var7) {
               var4.method2322(this.colourToReplace[var7], this.colourToReplaceWith[var7]);
            }
         }

         if(this.textureToReplace != null) {
            for(var7 = 0; var7 < this.textureToReplace.length; ++var7) {
               var4.method2320(this.textureToReplace[var7], this.textToReplaceWith[var7]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-420455114"
   )
   public String method4451(int var1, String var2) {
      return class165.method2965(this.field3507, var1, var2);
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
      this.field3540 = 0;
      this.field3513 = false;
      this.field3543 = -1;
      this.field3544 = -1;
      this.field3545 = -1;
      this.field3546 = -1;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IIB)I",
      garbageValue = "123"
   )
   public int method4455(int var1, int var2) {
      return Script.method1758(this.field3507, var1, var2);
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IB)LItemComposition;",
      garbageValue = "-124"
   )
   public ItemComposition method4458(int var1) {
      if(this.countObj != null && var1 > 1) {
         int var2 = -1;

         for(int var3 = 0; var3 < 10; ++var3) {
            if(var1 >= this.countCo[var3] && this.countCo[var3] != 0) {
               var2 = this.countObj[var3];
            }
         }

         if(var2 != -1) {
            return class224.getItemDefinition(var2);
         }
      }

      return this;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LItemComposition;LItemComposition;B)V",
      garbageValue = "4"
   )
   void method4473(ItemComposition var1, ItemComposition var2) {
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
      this.field3513 = false;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "36"
   )
   public int method4479() {
      return this.team != -1 && this.inventoryActions != null?(this.team >= 0?(this.inventoryActions[this.team] != null?this.team:-1):("Drop".equalsIgnoreCase(this.inventoryActions[4])?4:-1)):-1;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IB)LModel;",
      garbageValue = "24"
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
            return class224.getItemDefinition(var2).getModel(1);
         }
      }

      Model var5 = (Model)itemModelCache.get((long)this.id);
      if(var5 != null) {
         return var5;
      } else {
         ModelData var6 = ModelData.method2310(class95.field1485, this.inventoryModel, 0);
         if(var6 == null) {
            return null;
         } else {
            if(this.resizeX != 128 || this.resizeY != 128 || this.resizeZ != 128) {
               var6.method2325(this.resizeX, this.resizeY, this.resizeZ);
            }

            int var4;
            if(this.colourToReplace != null) {
               for(var4 = 0; var4 < this.colourToReplace.length; ++var4) {
                  var6.method2322(this.colourToReplace[var4], this.colourToReplaceWith[var4]);
               }
            }

            if(this.textureToReplace != null) {
               for(var4 = 0; var4 < this.textureToReplace.length; ++var4) {
                  var6.method2320(this.textureToReplace[var4], this.textToReplaceWith[var4]);
               }
            }

            var5 = var6.light(this.ambient + 64, this.contrast + 768, -50, -10, -50);
            var5.field1949 = true;
            itemModelCache.put(var5, (long)this.id);
            return var5;
         }
      }
   }

   static {
      field3497 = new NodeCache(64);
      itemModelCache = new NodeCache(50);
      itemSpriteCache = new NodeCache(200);
   }
}
