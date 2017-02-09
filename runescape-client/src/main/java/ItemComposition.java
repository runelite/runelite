import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gm")
@Implements("ItemComposition")
public class ItemComposition extends CacheableNode {
   @ObfuscatedName("h")
   @Export("colourToReplaceWith")
   short[] colourToReplaceWith;
   @ObfuscatedName("w")
   public static class182 field2930;
   @ObfuscatedName("j")
   @Export("isMembersWorld")
   public static boolean isMembersWorld;
   @ObfuscatedName("d")
   static NodeCache field2932 = new NodeCache(64);
   @ObfuscatedName("n")
   @Export("itemModelCache")
   static NodeCache itemModelCache = new NodeCache(50);
   @ObfuscatedName("c")
   @Export("itemSpriteCache")
   static NodeCache itemSpriteCache = new NodeCache(200);
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 1836690067
   )
   @Export("id")
   public int id;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1711884961
   )
   @Export("inventoryModel")
   int inventoryModel;
   @ObfuscatedName("v")
   @Export("name")
   public String name = "null";
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = -1543174571
   )
   int field2938 = -1;
   @ObfuscatedName("ic")
   @ObfuscatedGetter(
      intValue = -2098533977
   )
   static int field2939;
   @ObfuscatedName("p")
   @Export("textureToReplace")
   short[] textureToReplace;
   @ObfuscatedName("t")
   @Export("textToReplaceWith")
   short[] textToReplaceWith;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = 1966556647
   )
   @Export("zoom2d")
   public int zoom2d = 2000;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1072883061
   )
   @Export("xan2d")
   public int xan2d = 0;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = 528496183
   )
   @Export("yan2d")
   public int yan2d = 0;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1054804667
   )
   @Export("zan2d")
   public int zan2d = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = 382887659
   )
   @Export("offsetX2d")
   public int offsetX2d = 0;
   @ObfuscatedName("a")
   @Export("colourToReplace")
   short[] colourToReplace;
   @ObfuscatedName("ag")
   @Export("countObj")
   int[] countObj;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = -568096771
   )
   @Export("femaleHeadModel2")
   int femaleHeadModel2 = -1;
   @ObfuscatedName("ap")
   @Export("isMembers")
   public boolean isMembers = false;
   @ObfuscatedName("aq")
   @Export("groundActions")
   public String[] groundActions = new String[]{null, null, "Take", null, null};
   @ObfuscatedName("bl")
   @ObfuscatedGetter(
      intValue = 561617405
   )
   public int field2952 = -1;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -1826123051
   )
   @Export("contrast")
   public int contrast = 0;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1694253153
   )
   @Export("price")
   public int price = 1;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -1167602581
   )
   @Export("maleOffset")
   int maleOffset = 0;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = -782450679
   )
   @Export("femaleModel")
   int femaleModel = -1;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = 876853445
   )
   @Export("femaleModel1")
   int femaleModel1 = -1;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 1620985017
   )
   @Export("femaleOffset")
   int femaleOffset = 0;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = -589030503
   )
   @Export("maleModel2")
   int maleModel2 = -1;
   @ObfuscatedName("aw")
   @Export("inventoryActions")
   public String[] inventoryActions = new String[]{null, null, null, null, "Drop"};
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = 470765991
   )
   @Export("maleHeadModel")
   int maleHeadModel = -1;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -154071547
   )
   @Export("maleHeadModel2")
   int maleHeadModel2 = -1;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -2021444277
   )
   @Export("femaleHeadModel")
   int femaleHeadModel = -1;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 377702169
   )
   @Export("offsetY2d")
   public int offsetY2d = 0;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 1187222263
   )
   @Export("maleModel1")
   int maleModel1 = -1;
   @ObfuscatedName("at")
   @Export("countCo")
   int[] countCo;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 545402761
   )
   @Export("isStackable")
   public int isStackable = 0;
   @ObfuscatedName("bm")
   @ObfuscatedGetter(
      intValue = 2130193627
   )
   int field2968 = -1;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -1501316705
   )
   @Export("resizeX")
   int resizeX = 128;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -1015828193
   )
   @Export("resizeY")
   int resizeY = 128;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -1572479363
   )
   @Export("note")
   public int note = -1;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 1542953345
   )
   @Export("ambient")
   public int ambient = 0;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 712051915
   )
   @Export("team")
   public int team = 0;
   @ObfuscatedName("an")
   public boolean field2975 = false;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -1609336327
   )
   @Export("notedTemplate")
   public int notedTemplate = -1;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 728683253
   )
   @Export("resizeZ")
   int resizeZ = 128;
   @ObfuscatedName("bz")
   @ObfuscatedGetter(
      intValue = 1486657051
   )
   public int field2978 = -1;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 1558476903
   )
   @Export("maleModel")
   int maleModel = -1;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 1923320097
   )
   @Export("femaleModel2")
   int femaleModel2 = -1;

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(ZI)Z",
      garbageValue = "-2112041670"
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
         if(!field2930.method3275(var2, 0)) {
            var5 = false;
         }

         if(var3 != -1 && !field2930.method3275(var3, 0)) {
            var5 = false;
         }

         if(var4 != -1 && !field2930.method3275(var4, 0)) {
            var5 = false;
         }

         return var5;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1722963310"
   )
   void method3641() {
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1337705"
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

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(ZI)LModelData;",
      garbageValue = "406494188"
   )
   public final ModelData method3643(boolean var1) {
      int var2 = this.maleHeadModel;
      int var3 = this.maleHeadModel2;
      if(var1) {
         var2 = this.femaleHeadModel;
         var3 = this.femaleHeadModel2;
      }

      if(var2 == -1) {
         return null;
      } else {
         ModelData var4 = ModelData.method1470(field2930, var2, 0);
         if(var3 != -1) {
            ModelData var7 = ModelData.method1470(field2930, var3, 0);
            ModelData[] var6 = new ModelData[]{var4, var7};
            var4 = new ModelData(var6, 2);
         }

         int var5;
         if(this.colourToReplace != null) {
            for(var5 = 0; var5 < this.colourToReplace.length; ++var5) {
               var4.method1474(this.colourToReplace[var5], this.colourToReplaceWith[var5]);
            }
         }

         if(this.textureToReplace != null) {
            for(var5 = 0; var5 < this.textureToReplace.length; ++var5) {
               var4.method1484(this.textureToReplace[var5], this.textToReplaceWith[var5]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "175321904"
   )
   @Export("populateFromBuffer")
   void populateFromBuffer(Buffer var1, int var2) {
      if(var2 == 1) {
         this.inventoryModel = var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.name = var1.method2934();
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
         this.price = var1.method3062();
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
         this.groundActions[var2 - 30] = var1.method2934();
         if(this.groundActions[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.groundActions[var2 - 30] = null;
         }
      } else if(var2 >= 35 && var2 < 40) {
         this.inventoryActions[var2 - 35] = var1.method2934();
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
         } else if(var2 == 65) {
            this.field2975 = true;
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
            if(null == this.countObj) {
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
            this.field2938 = var1.readUnsignedShort();
         } else if(var2 == 140) {
            this.field2968 = var1.readUnsignedShort();
         } else if(var2 == 148) {
            this.field2978 = var1.readUnsignedShort();
         } else if(var2 == 149) {
            this.field2952 = var1.readUnsignedShort();
         }
      }

   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(LItemComposition;LItemComposition;I)V",
      garbageValue = "803972014"
   )
   void method3645(ItemComposition var1, ItemComposition var2) {
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
      if(null != var2.inventoryActions) {
         for(int var3 = 0; var3 < 4; ++var3) {
            this.inventoryActions[var3] = var2.inventoryActions[var3];
         }
      }

      this.inventoryActions[4] = "Discard";
      this.price = 0;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)LModelData;",
      garbageValue = "-1174542484"
   )
   public final ModelData method3647(int var1) {
      int var3;
      if(null != this.countObj && var1 > 1) {
         int var2 = -1;

         for(var3 = 0; var3 < 10; ++var3) {
            if(var1 >= this.countCo[var3] && this.countCo[var3] != 0) {
               var2 = this.countObj[var3];
            }
         }

         if(var2 != -1) {
            return PlayerComposition.getItemDefinition(var2).method3647(1);
         }
      }

      ModelData var4 = ModelData.method1470(field2930, this.inventoryModel, 0);
      if(var4 == null) {
         return null;
      } else {
         if(this.resizeX != 128 || this.resizeY != 128 || this.resizeZ != 128) {
            var4.method1515(this.resizeX, this.resizeY, this.resizeZ);
         }

         if(this.colourToReplace != null) {
            for(var3 = 0; var3 < this.colourToReplace.length; ++var3) {
               var4.method1474(this.colourToReplace[var3], this.colourToReplaceWith[var3]);
            }
         }

         if(null != this.textureToReplace) {
            for(var3 = 0; var3 < this.textureToReplace.length; ++var3) {
               var4.method1484(this.textureToReplace[var3], this.textToReplaceWith[var3]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)LModel;",
      garbageValue = "-674015209"
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
            return PlayerComposition.getItemDefinition(var2).getModel(1);
         }
      }

      Model var6 = (Model)itemModelCache.get((long)this.id);
      if(null != var6) {
         return var6;
      } else {
         ModelData var5 = ModelData.method1470(field2930, this.inventoryModel, 0);
         if(var5 == null) {
            return null;
         } else {
            if(this.resizeX != 128 || this.resizeY != 128 || this.resizeZ != 128) {
               var5.method1515(this.resizeX, this.resizeY, this.resizeZ);
            }

            int var4;
            if(this.colourToReplace != null) {
               for(var4 = 0; var4 < this.colourToReplace.length; ++var4) {
                  var5.method1474(this.colourToReplace[var4], this.colourToReplaceWith[var4]);
               }
            }

            if(this.textureToReplace != null) {
               for(var4 = 0; var4 < this.textureToReplace.length; ++var4) {
                  var5.method1484(this.textureToReplace[var4], this.textToReplaceWith[var4]);
               }
            }

            var6 = var5.method1491(this.ambient + 64, 768 + this.contrast, -50, -10, -50);
            var6.field1378 = true;
            itemModelCache.put(var6, (long)this.id);
            return var6;
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ZI)LModelData;",
      garbageValue = "817138889"
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
         ModelData var5 = ModelData.method1470(field2930, var2, 0);
         if(var3 != -1) {
            ModelData var9 = ModelData.method1470(field2930, var3, 0);
            if(var4 != -1) {
               ModelData var7 = ModelData.method1470(field2930, var4, 0);
               ModelData[] var8 = new ModelData[]{var5, var9, var7};
               var5 = new ModelData(var8, 3);
            } else {
               ModelData[] var10 = new ModelData[]{var5, var9};
               var5 = new ModelData(var10, 2);
            }
         }

         if(!var1 && this.maleOffset != 0) {
            var5.method1482(0, this.maleOffset, 0);
         }

         if(var1 && this.femaleOffset != 0) {
            var5.method1482(0, this.femaleOffset, 0);
         }

         int var6;
         if(this.colourToReplace != null) {
            for(var6 = 0; var6 < this.colourToReplace.length; ++var6) {
               var5.method1474(this.colourToReplace[var6], this.colourToReplaceWith[var6]);
            }
         }

         if(null != this.textureToReplace) {
            for(var6 = 0; var6 < this.textureToReplace.length; ++var6) {
               var5.method1484(this.textureToReplace[var6], this.textToReplaceWith[var6]);
            }
         }

         return var5;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(II)LItemComposition;",
      garbageValue = "2126217226"
   )
   public ItemComposition method3653(int var1) {
      if(null != this.countObj && var1 > 1) {
         int var2 = -1;

         for(int var3 = 0; var3 < 10; ++var3) {
            if(var1 >= this.countCo[var3] && this.countCo[var3] != 0) {
               var2 = this.countObj[var3];
            }
         }

         if(var2 != -1) {
            return PlayerComposition.getItemDefinition(var2);
         }
      }

      return this;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(LItemComposition;LItemComposition;I)V",
      garbageValue = "509268931"
   )
   void method3667(ItemComposition var1, ItemComposition var2) {
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
      this.field2975 = false;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(LItemComposition;LItemComposition;I)V",
      garbageValue = "1981013691"
   )
   void method3679(ItemComposition var1, ItemComposition var2) {
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

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(ZI)Z",
      garbageValue = "-215815045"
   )
   public final boolean method3694(boolean var1) {
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
         if(!field2930.method3275(var2, 0)) {
            var4 = false;
         }

         if(var3 != -1 && !field2930.method3275(var3, 0)) {
            var4 = false;
         }

         return var4;
      }
   }
}
