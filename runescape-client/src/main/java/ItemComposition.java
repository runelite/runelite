import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gu")
@Implements("ItemComposition")
public class ItemComposition extends CacheableNode {
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -658544611
   )
   @Export("femaleHeadModel2")
   int femaleHeadModel2 = -1;
   @ObfuscatedName("p")
   public static IndexDataBase field2979;
   @ObfuscatedName("z")
   @Export("isMembersWorld")
   public static boolean isMembersWorld;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1069905835
   )
   public static int field2981;
   @ObfuscatedName("v")
   public static NodeCache field2982 = new NodeCache(64);
   @ObfuscatedName("g")
   @Export("itemModelCache")
   public static NodeCache itemModelCache = new NodeCache(50);
   @ObfuscatedName("w")
   @Export("itemSpriteCache")
   public static NodeCache itemSpriteCache = new NodeCache(200);
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 1999916325
   )
   @Export("resizeY")
   int resizeY = 128;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1250621039
   )
   @Export("inventoryModel")
   int inventoryModel;
   @ObfuscatedName("bo")
   class142 field2988;
   @ObfuscatedName("j")
   @Export("colourToReplace")
   short[] colourToReplace;
   @ObfuscatedName("i")
   @Export("colourToReplaceWith")
   short[] colourToReplaceWith;
   @ObfuscatedName("a")
   @Export("textureToReplace")
   short[] textureToReplace;
   @ObfuscatedName("x")
   @Export("textToReplaceWith")
   short[] textToReplaceWith;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1566189951
   )
   @Export("zoom2d")
   public int zoom2d = 2000;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1966871349
   )
   @Export("xan2d")
   public int xan2d = 0;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = -1940472447
   )
   public int field2995 = 0;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 190991875
   )
   @Export("zan2d")
   public int zan2d = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -2085370987
   )
   @Export("offsetX2d")
   public int offsetX2d = 0;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -1619102915
   )
   @Export("offsetY2d")
   public int offsetY2d = 0;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 1931864799
   )
   @Export("isStackable")
   public int isStackable = 0;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = -1320705365
   )
   public int field3000 = -1;
   @ObfuscatedName("ac")
   @Export("isMembers")
   public boolean isMembers = false;
   @ObfuscatedName("az")
   @Export("groundActions")
   public String[] groundActions = new String[]{null, null, "Take", null, null};
   @ObfuscatedName("ao")
   @Export("inventoryActions")
   public String[] inventoryActions = new String[]{null, null, null, null, "Drop"};
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1951256663
   )
   @Export("yan2d")
   public int yan2d = 0;
   @ObfuscatedName("r")
   public static Font field3005;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -656119679
   )
   @Export("maleModel1")
   int maleModel1 = -1;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -772723903
   )
   @Export("maleOffset")
   int maleOffset = 0;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 397378321
   )
   @Export("femaleModel")
   int femaleModel = -1;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = -1100156955
   )
   @Export("maleModel")
   int maleModel = -1;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 932711687
   )
   @Export("femaleOffset")
   int femaleOffset = 0;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 691998327
   )
   @Export("femaleHeadModel")
   int femaleHeadModel = -1;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -1152741527
   )
   @Export("femaleModel2")
   int femaleModel2 = -1;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = -1350915877
   )
   @Export("maleHeadModel")
   int maleHeadModel = -1;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 1810200819
   )
   @Export("maleHeadModel2")
   int maleHeadModel2 = -1;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 121909049
   )
   @Export("id")
   public int id;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = -631814961
   )
   public int field3016 = -1;
   @ObfuscatedName("bw")
   public boolean field3017 = false;
   @ObfuscatedName("an")
   @Export("countCo")
   int[] countCo;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 1634987737
   )
   @Export("note")
   public int note = -1;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -1958307169
   )
   @Export("notedTemplate")
   public int notedTemplate = -1;
   @ObfuscatedName("e")
   @Export("name")
   public String name = "null";
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -2006336729
   )
   @Export("price")
   public int price = 1;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 85685947
   )
   @Export("resizeZ")
   int resizeZ = 128;
   @ObfuscatedName("bu")
   @ObfuscatedGetter(
      intValue = 1500457707
   )
   @Export("ambient")
   public int ambient = 0;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -792647933
   )
   @Export("maleModel2")
   int maleModel2 = -1;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -162473569
   )
   @Export("femaleModel1")
   int femaleModel1 = -1;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -1838048127
   )
   @Export("resizeX")
   int resizeX = 128;
   @ObfuscatedName("ad")
   @Export("countObj")
   int[] countObj;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = -361805239
   )
   int field3029 = -1;
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = 664743969
   )
   int field3030 = -1;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 1963962969
   )
   @Export("team")
   int team = -2;
   @ObfuscatedName("br")
   @ObfuscatedGetter(
      intValue = 21095035
   )
   @Export("contrast")
   public int contrast = 0;

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1702899305"
   )
   void method3736() {
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "2058140308"
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
            this.field3017 = true;
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
            this.field2995 = var1.readUnsignedByte();
         } else if(var2 == 139) {
            this.field3029 = var1.readUnsignedShort();
         } else if(var2 == 140) {
            this.field3030 = var1.readUnsignedShort();
         } else if(var2 == 148) {
            this.field3016 = var1.readUnsignedShort();
         } else if(var2 == 149) {
            this.field3000 = var1.readUnsignedShort();
         } else if(var2 == 249) {
            this.field2988 = class180.method3283(var1, this.field2988);
         }
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(LItemComposition;LItemComposition;I)V",
      garbageValue = "-93522666"
   )
   void method3739(ItemComposition var1, ItemComposition var2) {
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

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(II)LModel;",
      garbageValue = "1998457815"
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
            return class47.getItemDefinition(var2).getModel(1);
         }
      }

      Model var6 = (Model)itemModelCache.get((long)this.id);
      if(var6 != null) {
         return var6;
      } else {
         ModelData var5 = ModelData.method1479(class189.field2787, this.inventoryModel, 0);
         if(var5 == null) {
            return null;
         } else {
            if(this.resizeX != 128 || this.resizeY != 128 || this.resizeZ != 128) {
               var5.method1494(this.resizeX, this.resizeY, this.resizeZ);
            }

            int var4;
            if(this.colourToReplace != null) {
               for(var4 = 0; var4 < this.colourToReplace.length; ++var4) {
                  var5.method1491(this.colourToReplace[var4], this.colourToReplaceWith[var4]);
               }
            }

            if(this.textureToReplace != null) {
               for(var4 = 0; var4 < this.textureToReplace.length; ++var4) {
                  var5.method1492(this.textureToReplace[var4], this.textToReplaceWith[var4]);
               }
            }

            var6 = var5.method1502(this.ambient + 64, this.contrast + 768, -50, -10, -50);
            var6.field1370 = true;
            itemModelCache.put(var6, (long)this.id);
            return var6;
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(II)LItemComposition;",
      garbageValue = "837324781"
   )
   public ItemComposition method3744(int var1) {
      if(this.countObj != null && var1 > 1) {
         int var2 = -1;

         for(int var3 = 0; var3 < 10; ++var3) {
            if(var1 >= this.countCo[var3] && this.countCo[var3] != 0) {
               var2 = this.countObj[var3];
            }
         }

         if(var2 != -1) {
            return class47.getItemDefinition(var2);
         }
      }

      return this;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(LItemComposition;LItemComposition;I)V",
      garbageValue = "135245481"
   )
   void method3745(ItemComposition var1, ItemComposition var2) {
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
      this.field3017 = false;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(ZB)LModelData;",
      garbageValue = "9"
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
         ModelData var5 = ModelData.method1479(class189.field2787, var2, 0);
         if(var3 != -1) {
            ModelData var6 = ModelData.method1479(class189.field2787, var3, 0);
            if(var4 != -1) {
               ModelData var7 = ModelData.method1479(class189.field2787, var4, 0);
               ModelData[] var8 = new ModelData[]{var5, var6, var7};
               var5 = new ModelData(var8, 3);
            } else {
               ModelData[] var10 = new ModelData[]{var5, var6};
               var5 = new ModelData(var10, 2);
            }
         }

         if(!var1 && this.maleOffset != 0) {
            var5.method1535(0, this.maleOffset, 0);
         }

         if(var1 && this.femaleOffset != 0) {
            var5.method1535(0, this.femaleOffset, 0);
         }

         int var9;
         if(this.colourToReplace != null) {
            for(var9 = 0; var9 < this.colourToReplace.length; ++var9) {
               var5.method1491(this.colourToReplace[var9], this.colourToReplaceWith[var9]);
            }
         }

         if(this.textureToReplace != null) {
            for(var9 = 0; var9 < this.textureToReplace.length; ++var9) {
               var5.method1492(this.textureToReplace[var9], this.textToReplaceWith[var9]);
            }
         }

         return var5;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ZI)Z",
      garbageValue = "-2097536161"
   )
   public final boolean method3747(boolean var1) {
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
         if(!class189.field2787.method3297(var2, 0)) {
            var4 = false;
         }

         if(var3 != -1 && !class189.field2787.method3297(var3, 0)) {
            var4 = false;
         }

         return var4;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(ZI)LModelData;",
      garbageValue = "-2046255871"
   )
   public final ModelData method3748(boolean var1) {
      int var2 = this.maleHeadModel;
      int var3 = this.maleHeadModel2;
      if(var1) {
         var2 = this.femaleHeadModel;
         var3 = this.femaleHeadModel2;
      }

      if(var2 == -1) {
         return null;
      } else {
         ModelData var4 = ModelData.method1479(class189.field2787, var2, 0);
         if(var3 != -1) {
            ModelData var7 = ModelData.method1479(class189.field2787, var3, 0);
            ModelData[] var6 = new ModelData[]{var4, var7};
            var4 = new ModelData(var6, 2);
         }

         int var5;
         if(this.colourToReplace != null) {
            for(var5 = 0; var5 < this.colourToReplace.length; ++var5) {
               var4.method1491(this.colourToReplace[var5], this.colourToReplaceWith[var5]);
            }
         }

         if(this.textureToReplace != null) {
            for(var5 = 0; var5 < this.textureToReplace.length; ++var5) {
               var4.method1492(this.textureToReplace[var5], this.textToReplaceWith[var5]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "516496333"
   )
   public int method3749(int var1, int var2) {
      return IndexData.method3408(this.field2988, var1, var2);
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "910026343"
   )
   public String method3750(int var1, String var2) {
      return class164.method3100(this.field2988, var1, var2);
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ZI)Z",
      garbageValue = "-2146846484"
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
         if(!class189.field2787.method3297(var2, 0)) {
            var5 = false;
         }

         if(var3 != -1 && !class189.field2787.method3297(var3, 0)) {
            var5 = false;
         }

         if(var4 != -1 && !class189.field2787.method3297(var4, 0)) {
            var5 = false;
         }

         return var5;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "178052471"
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
      signature = "(LItemComposition;LItemComposition;S)V",
      garbageValue = "1827"
   )
   void method3767(ItemComposition var1, ItemComposition var2) {
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
      this.field2995 = var2.field2995;
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

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1730751471"
   )
   public int method3776() {
      return this.team != -1 && this.inventoryActions != null?(this.team >= 0?(this.inventoryActions[this.team] != null?this.team:-1):("Drop".equalsIgnoreCase(this.inventoryActions[4])?4:-1)):-1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(II)LModelData;",
      garbageValue = "1497913481"
   )
   public final ModelData method3785(int var1) {
      int var3;
      if(this.countObj != null && var1 > 1) {
         int var4 = -1;

         for(var3 = 0; var3 < 10; ++var3) {
            if(var1 >= this.countCo[var3] && this.countCo[var3] != 0) {
               var4 = this.countObj[var3];
            }
         }

         if(var4 != -1) {
            return class47.getItemDefinition(var4).method3785(1);
         }
      }

      ModelData var2 = ModelData.method1479(class189.field2787, this.inventoryModel, 0);
      if(var2 == null) {
         return null;
      } else {
         if(this.resizeX != 128 || this.resizeY != 128 || this.resizeZ != 128) {
            var2.method1494(this.resizeX, this.resizeY, this.resizeZ);
         }

         if(this.colourToReplace != null) {
            for(var3 = 0; var3 < this.colourToReplace.length; ++var3) {
               var2.method1491(this.colourToReplace[var3], this.colourToReplaceWith[var3]);
            }
         }

         if(this.textureToReplace != null) {
            for(var3 = 0; var3 < this.textureToReplace.length; ++var3) {
               var2.method1492(this.textureToReplace[var3], this.textToReplaceWith[var3]);
            }
         }

         return var2;
      }
   }

   @ObfuscatedName("af")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1345719386"
   )
   static void method3798(int var0) {
      Client.field296 = 0L;
      if(var0 >= 2) {
         Client.isResized = true;
      } else {
         Client.isResized = false;
      }

      class138.method2672();
      if(Client.gameState >= 25) {
         Actor.method593();
      }

      GameEngine.field1777 = true;
   }
}
