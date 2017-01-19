import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("gs")
@Implements("ItemComposition")
public class ItemComposition extends CacheableNode {
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -2005069229
   )
   @Export("femaleHeadModel2")
   int femaleHeadModel2 = -1;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 1640717929
   )
   @Export("maleHeadModel2")
   int maleHeadModel2 = -1;
   @ObfuscatedName("bw")
   @ObfuscatedGetter(
      intValue = -1513828519
   )
   int field2954 = -1;
   @ObfuscatedName("b")
   @Export("itemModelCache")
   public static NodeCache itemModelCache = new NodeCache(50);
   @ObfuscatedName("x")
   @Export("itemSpriteCache")
   public static NodeCache itemSpriteCache = new NodeCache(200);
   @ObfuscatedName("r")
   static Font field2957;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1054787989
   )
   @Export("id")
   public int id;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -1142073623
   )
   @Export("inventoryModel")
   int inventoryModel;
   @ObfuscatedName("j")
   @Export("name")
   public String name = "null";
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -123127569
   )
   @Export("yan2d")
   public int yan2d = 0;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 26836949
   )
   public static int field2962;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 700278995
   )
   @Export("resizeZ")
   int resizeZ = 128;
   @ObfuscatedName("i")
   @Export("textToReplaceWith")
   short[] textToReplaceWith;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 174239999
   )
   @Export("zoom2d")
   public int zoom2d = 2000;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 873592989
   )
   @Export("xan2d")
   public int xan2d = 0;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = -39423401
   )
   @Export("offsetY2d")
   public int offsetY2d = 0;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -451533919
   )
   @Export("zan2d")
   public int zan2d = 0;
   @ObfuscatedName("w")
   @Export("colourToReplace")
   short[] colourToReplace;
   @ObfuscatedName("af")
   @Export("countObj")
   int[] countObj;
   @ObfuscatedName("o")
   @Export("textureToReplace")
   short[] textureToReplace;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1142872049
   )
   @Export("price")
   public int price = 1;
   @ObfuscatedName("az")
   @Export("isMembers")
   public boolean isMembers = false;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -207978419
   )
   @Export("maleModel1")
   int maleModel1 = -1;
   @ObfuscatedName("ad")
   @Export("inventoryActions")
   public String[] inventoryActions = new String[]{null, null, null, null, "Drop"};
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 1499346931
   )
   @Export("maleModel")
   int maleModel = -1;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 2055419219
   )
   @Export("femaleHeadModel")
   int femaleHeadModel = -1;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 1806914347
   )
   @Export("femaleModel2")
   int femaleModel2 = -1;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = 1539190399
   )
   @Export("femaleModel")
   int femaleModel = -1;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 1109300711
   )
   @Export("maleOffset")
   int maleOffset = 0;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 405247881
   )
   @Export("femaleOffset")
   int femaleOffset = 0;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -1801261827
   )
   @Export("ambient")
   public int ambient = 0;
   @ObfuscatedName("aj")
   @Export("countCo")
   int[] countCo;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1250095117
   )
   @Export("offsetX2d")
   public int offsetX2d = 0;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 2076270963
   )
   @Export("femaleModel1")
   int femaleModel1 = -1;
   @ObfuscatedName("u")
   public static NodeCache field2986 = new NodeCache(64);
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -687408083
   )
   @Export("maleModel2")
   int maleModel2 = -1;
   @ObfuscatedName("g")
   @Export("isMembersWorld")
   public static boolean isMembersWorld;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 264657793
   )
   @Export("isStackable")
   public int isStackable = 0;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = 378247189
   )
   @Export("note")
   public int note = -1;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 1822932295
   )
   @Export("notedTemplate")
   public int notedTemplate = -1;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = 2010548103
   )
   @Export("resizeX")
   int resizeX = 128;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -1632101267
   )
   @Export("resizeY")
   int resizeY = 128;
   @ObfuscatedName("p")
   @Export("colourToReplaceWith")
   short[] colourToReplaceWith;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 400689011
   )
   @Export("maleHeadModel")
   int maleHeadModel = -1;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 1134475491
   )
   @Export("contrast")
   public int contrast = 0;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 1242044227
   )
   @Export("team")
   public int team = 0;
   @ObfuscatedName("ab")
   public boolean field2998 = false;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = 1996022797
   )
   int field2999 = -1;
   @ObfuscatedName("ai")
   @Export("groundActions")
   public String[] groundActions = new String[]{null, null, "Take", null, null};
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = 1042679681
   )
   public int field3001 = -1;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = -1496865371
   )
   public int field3002 = -1;
   @ObfuscatedName("cn")
   static class110 field3003;

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1634655088"
   )
   void method3525() {
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "-1384953116"
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

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "-76"
   )
   @Export("populateFromBuffer")
   void populateFromBuffer(Buffer var1, int var2) {
      if(var2 == 1) {
         this.inventoryModel = var1.readUnsignedShort();
      } else if(var2 == 2) {
         this.name = var1.method2911();
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
         this.price = var1.method2727();
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
         this.groundActions[var2 - 30] = var1.method2911();
         if(this.groundActions[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.groundActions[var2 - 30] = null;
         }
      } else if(var2 >= 35 && var2 < 40) {
         this.inventoryActions[var2 - 35] = var1.method2911();
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
            this.field2998 = true;
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
            this.field2999 = var1.readUnsignedShort();
         } else if(var2 == 140) {
            this.field2954 = var1.readUnsignedShort();
         } else if(var2 == 148) {
            this.field3001 = var1.readUnsignedShort();
         } else if(var2 == 149) {
            this.field3002 = var1.readUnsignedShort();
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(LItemComposition;LItemComposition;B)V",
      garbageValue = "65"
   )
   void method3528(ItemComposition var1, ItemComposition var2) {
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

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(LItemComposition;LItemComposition;I)V",
      garbageValue = "-1516370424"
   )
   void method3529(ItemComposition var1, ItemComposition var2) {
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

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(LItemComposition;LItemComposition;I)V",
      garbageValue = "-143723128"
   )
   void method3530(ItemComposition var1, ItemComposition var2) {
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
      this.field2998 = false;
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IB)LModelData;",
      garbageValue = "1"
   )
   public final ModelData method3531(int var1) {
      int var3;
      if(null != this.countObj && var1 > 1) {
         int var2 = -1;

         for(var3 = 0; var3 < 10; ++var3) {
            if(var1 >= this.countCo[var3] && this.countCo[var3] != 0) {
               var2 = this.countObj[var3];
            }
         }

         if(var2 != -1) {
            return NPC.getItemDefinition(var2).method3531(1);
         }
      }

      ModelData var4 = ModelData.method1426(Frames.field1570, this.inventoryModel, 0);
      if(var4 == null) {
         return null;
      } else {
         if(this.resizeX != 128 || this.resizeY != 128 || this.resizeZ != 128) {
            var4.method1449(this.resizeX, this.resizeY, this.resizeZ);
         }

         if(null != this.colourToReplace) {
            for(var3 = 0; var3 < this.colourToReplace.length; ++var3) {
               var4.method1439(this.colourToReplace[var3], this.colourToReplaceWith[var3]);
            }
         }

         if(this.textureToReplace != null) {
            for(var3 = 0; var3 < this.textureToReplace.length; ++var3) {
               var4.method1440(this.textureToReplace[var3], this.textToReplaceWith[var3]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(ZI)LModelData;",
      garbageValue = "1723845011"
   )
   public final ModelData method3537(boolean var1) {
      int var2 = this.maleHeadModel;
      int var3 = this.maleHeadModel2;
      if(var1) {
         var2 = this.femaleHeadModel;
         var3 = this.femaleHeadModel2;
      }

      if(var2 == -1) {
         return null;
      } else {
         ModelData var4 = ModelData.method1426(Frames.field1570, var2, 0);
         if(var3 != -1) {
            ModelData var5 = ModelData.method1426(Frames.field1570, var3, 0);
            ModelData[] var6 = new ModelData[]{var4, var5};
            var4 = new ModelData(var6, 2);
         }

         int var7;
         if(null != this.colourToReplace) {
            for(var7 = 0; var7 < this.colourToReplace.length; ++var7) {
               var4.method1439(this.colourToReplace[var7], this.colourToReplaceWith[var7]);
            }
         }

         if(null != this.textureToReplace) {
            for(var7 = 0; var7 < this.textureToReplace.length; ++var7) {
               var4.method1440(this.textureToReplace[var7], this.textToReplaceWith[var7]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(ZI)LModelData;",
      garbageValue = "-2039192267"
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
         ModelData var5 = ModelData.method1426(Frames.field1570, var2, 0);
         if(var3 != -1) {
            ModelData var6 = ModelData.method1426(Frames.field1570, var3, 0);
            if(var4 != -1) {
               ModelData var7 = ModelData.method1426(Frames.field1570, var4, 0);
               ModelData[] var8 = new ModelData[]{var5, var6, var7};
               var5 = new ModelData(var8, 3);
            } else {
               ModelData[] var10 = new ModelData[]{var5, var6};
               var5 = new ModelData(var10, 2);
            }
         }

         if(!var1 && this.maleOffset != 0) {
            var5.method1467(0, this.maleOffset, 0);
         }

         if(var1 && this.femaleOffset != 0) {
            var5.method1467(0, this.femaleOffset, 0);
         }

         int var9;
         if(this.colourToReplace != null) {
            for(var9 = 0; var9 < this.colourToReplace.length; ++var9) {
               var5.method1439(this.colourToReplace[var9], this.colourToReplaceWith[var9]);
            }
         }

         if(null != this.textureToReplace) {
            for(var9 = 0; var9 < this.textureToReplace.length; ++var9) {
               var5.method1440(this.textureToReplace[var9], this.textToReplaceWith[var9]);
            }
         }

         return var5;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ZI)Z",
      garbageValue = "540994960"
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
         if(!Frames.field1570.method3184(var2, 0)) {
            var5 = false;
         }

         if(var3 != -1 && !Frames.field1570.method3184(var3, 0)) {
            var5 = false;
         }

         if(var4 != -1 && !Frames.field1570.method3184(var4, 0)) {
            var5 = false;
         }

         return var5;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)LItemComposition;",
      garbageValue = "1569255922"
   )
   public ItemComposition method3553(int var1) {
      if(this.countObj != null && var1 > 1) {
         int var2 = -1;

         for(int var3 = 0; var3 < 10; ++var3) {
            if(var1 >= this.countCo[var3] && this.countCo[var3] != 0) {
               var2 = this.countObj[var3];
            }
         }

         if(var2 != -1) {
            return NPC.getItemDefinition(var2);
         }
      }

      return this;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ZB)Z",
      garbageValue = "24"
   )
   public final boolean method3559(boolean var1) {
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
         if(!Frames.field1570.method3184(var2, 0)) {
            var4 = false;
         }

         if(var3 != -1 && !Frames.field1570.method3184(var3, 0)) {
            var4 = false;
         }

         return var4;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IB)LModel;",
      garbageValue = "-91"
   )
   @Export("getModel")
   public final Model getModel(int var1) {
      if(null != this.countObj && var1 > 1) {
         int var5 = -1;

         for(int var3 = 0; var3 < 10; ++var3) {
            if(var1 >= this.countCo[var3] && this.countCo[var3] != 0) {
               var5 = this.countObj[var3];
            }
         }

         if(var5 != -1) {
            return NPC.getItemDefinition(var5).getModel(1);
         }
      }

      Model var2 = (Model)itemModelCache.get((long)this.id);
      if(null != var2) {
         return var2;
      } else {
         ModelData var6 = ModelData.method1426(Frames.field1570, this.inventoryModel, 0);
         if(var6 == null) {
            return null;
         } else {
            if(this.resizeX != 128 || this.resizeY != 128 || this.resizeZ != 128) {
               var6.method1449(this.resizeX, this.resizeY, this.resizeZ);
            }

            int var4;
            if(null != this.colourToReplace) {
               for(var4 = 0; var4 < this.colourToReplace.length; ++var4) {
                  var6.method1439(this.colourToReplace[var4], this.colourToReplaceWith[var4]);
               }
            }

            if(this.textureToReplace != null) {
               for(var4 = 0; var4 < this.textureToReplace.length; ++var4) {
                  var6.method1440(this.textureToReplace[var4], this.textToReplaceWith[var4]);
               }
            }

            var2 = var6.method1446(64 + this.ambient, this.contrast + 768, -50, -10, -50);
            var2.field1382 = true;
            itemModelCache.put(var2, (long)this.id);
            return var2;
         }
      }
   }

   @ObfuscatedName("bk")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "0"
   )
   @Export("groundItemSpawned")
   static final void groundItemSpawned(int var0, int var1) {
      Deque var2 = Client.groundItemDeque[class118.plane][var0][var1];
      if(var2 == null) {
         class0.region.method1679(class118.plane, var0, var1);
      } else {
         long var3 = -99999999L;
         Item var5 = null;

         Item var6;
         for(var6 = (Item)var2.method2330(); null != var6; var6 = (Item)var2.method2346()) {
            ItemComposition var7 = NPC.getItemDefinition(var6.id);
            long var8 = (long)var7.price;
            if(var7.isStackable == 1) {
               var8 *= (long)(1 + var6.quantity);
            }

            if(var8 > var3) {
               var3 = var8;
               var5 = var6;
            }
         }

         if(null == var5) {
            class0.region.method1679(class118.plane, var0, var1);
         } else {
            var2.method2326(var5);
            Item var11 = null;
            Item var10 = null;

            for(var6 = (Item)var2.method2330(); null != var6; var6 = (Item)var2.method2346()) {
               if(var5.id != var6.id) {
                  if(null == var11) {
                     var11 = var6;
                  }

                  if(var11.id != var6.id && var10 == null) {
                     var10 = var6;
                  }
               }
            }

            int var9 = 1610612736 + var0 + (var1 << 7);
            class0.region.method1801(class118.plane, var0, var1, XClanMember.method223(128 * var0 + 64, 64 + 128 * var1, class118.plane), var5, var9, var11, var10);
         }
      }
   }
}
