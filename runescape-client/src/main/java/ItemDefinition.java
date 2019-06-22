import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jv")
@Implements("ItemDefinition")
public class ItemDefinition extends DualNode {
   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   @Export("ItemDefinition_indexCache")
   public static AbstractIndexCache ItemDefinition_indexCache;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lir;"
   )
   @Export("ItemDefinition_modelIndexCache")
   public static AbstractIndexCache ItemDefinition_modelIndexCache;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Ler;"
   )
   @Export("ItemDefinition_cached")
   static EvictingDualNodeHashTable ItemDefinition_cached;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Ler;"
   )
   @Export("ItemDefinition_cachedModels")
   static EvictingDualNodeHashTable ItemDefinition_cachedModels;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Ler;"
   )
   @Export("Sprite_cached")
   static EvictingDualNodeHashTable Sprite_cached;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -590103687
   )
   @Export("id")
   public int id;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1070080857
   )
   @Export("__a")
   int __a;
   @ObfuscatedName("z")
   @Export("name")
   public String name;
   @ObfuscatedName("j")
   @Export("recolorFrom")
   short[] recolorFrom;
   @ObfuscatedName("s")
   @Export("recolorTo")
   short[] recolorTo;
   @ObfuscatedName("t")
   @Export("retextureFrom")
   short[] retextureFrom;
   @ObfuscatedName("y")
   @Export("retextureTo")
   short[] retextureTo;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 278037959
   )
   @Export("zoom2d")
   public int zoom2d;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 880150839
   )
   @Export("xan2d")
   public int xan2d;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 507808107
   )
   @Export("yan2d")
   public int yan2d;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 551313257
   )
   @Export("zan2d")
   public int zan2d;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -533708435
   )
   @Export("offsetX2d")
   public int offsetX2d;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -2130350563
   )
   @Export("offsetY2d")
   public int offsetY2d;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = -237597001
   )
   @Export("isStackable")
   public int isStackable;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = -343501105
   )
   @Export("price")
   public int price;
   @ObfuscatedName("aj")
   @Export("isMembersOnly")
   public boolean isMembersOnly;
   @ObfuscatedName("av")
   @Export("groundActions")
   public String[] groundActions;
   @ObfuscatedName("ar")
   @Export("inventoryActions")
   public String[] inventoryActions;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = 881309855
   )
   @Export("shiftClickIndex0")
   int shiftClickIndex0;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = 939367983
   )
   @Export("maleModel")
   int maleModel;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = 140643039
   )
   @Export("maleModel1")
   int maleModel1;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -1378899027
   )
   @Export("maleOffset")
   int maleOffset;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 886682223
   )
   @Export("femaleModel")
   int femaleModel;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = 154223105
   )
   @Export("femaleModel1")
   int femaleModel1;
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -1619361485
   )
   @Export("femaleOffset")
   int femaleOffset;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -691559863
   )
   @Export("maleModel2")
   int maleModel2;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -771136925
   )
   @Export("femaleModel2")
   int femaleModel2;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -650184697
   )
   @Export("maleHeadModel")
   int maleHeadModel;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = 548044049
   )
   @Export("maleHeadModel2")
   int maleHeadModel2;
   @ObfuscatedName("am")
   @ObfuscatedGetter(
      intValue = 1709659237
   )
   @Export("femaleHeadModel")
   int femaleHeadModel;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 106668727
   )
   @Export("femaleHeadModel2")
   int femaleHeadModel2;
   @ObfuscatedName("az")
   @Export("__az")
   int[] __az;
   @ObfuscatedName("au")
   @Export("__au")
   int[] __au;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 619422509
   )
   @Export("note")
   public int note;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -2121346423
   )
   @Export("noteTemplate")
   public int noteTemplate;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 69034859
   )
   @Export("resizeX")
   int resizeX;
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -17174497
   )
   @Export("resizeY")
   int resizeY;
   @ObfuscatedName("ai")
   @ObfuscatedGetter(
      intValue = 1395132907
   )
   @Export("resizeZ")
   int resizeZ;
   @ObfuscatedName("ba")
   @ObfuscatedGetter(
      intValue = 738319589
   )
   @Export("ambient")
   public int ambient;
   @ObfuscatedName("bb")
   @ObfuscatedGetter(
      intValue = -396977461
   )
   @Export("contrast")
   public int contrast;
   @ObfuscatedName("bs")
   @ObfuscatedGetter(
      intValue = -1057008657
   )
   @Export("int1")
   public int int1;
   @ObfuscatedName("bq")
   @ObfuscatedSignature(
      signature = "Llh;"
   )
   @Export("params")
   IterableNodeHashTable params;
   @ObfuscatedName("bn")
   @Export("isTradable")
   public boolean isTradable;
   @ObfuscatedName("bk")
   @ObfuscatedGetter(
      intValue = 700576005
   )
   @Export("unnotedId")
   int unnotedId;
   @ObfuscatedName("bd")
   @ObfuscatedGetter(
      intValue = -1969719185
   )
   @Export("notedId")
   int notedId;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = 807815565
   )
   @Export("placeholder")
   public int placeholder;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = -1854342455
   )
   @Export("placeholderTemplate")
   public int placeholderTemplate;

   ItemDefinition() {
      this.name = "null";
      this.zoom2d = 2000;
      this.xan2d = 0;
      this.yan2d = 0;
      this.zan2d = 0;
      this.offsetX2d = 0;
      this.offsetY2d = 0;
      this.isStackable = 0;
      this.price = 1;
      this.isMembersOnly = false;
      this.groundActions = new String[]{null, null, "Take", null, null};
      this.inventoryActions = new String[]{null, null, null, null, "Drop"};
      this.shiftClickIndex0 = -2;
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
      this.noteTemplate = -1;
      this.resizeX = 128;
      this.resizeY = 128;
      this.resizeZ = 128;
      this.ambient = 0;
      this.contrast = 0;
      this.int1 = 0;
      this.isTradable = false;
      this.unnotedId = -1;
      this.notedId = -1;
      this.placeholder = -1;
      this.placeholderTemplate = -1;
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1659281458"
   )
   @Export("post")
   void post() {
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lgr;I)V",
      garbageValue = "-781492560"
   )
   @Export("read")
   void read(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.readNext(var1, var2);
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lgr;II)V",
      garbageValue = "-1975780739"
   )
   @Export("readNext")
   void readNext(Buffer var1, int var2) {
      if(var2 == 1) {
         this.__a = var1.__ag_302();
      } else if(var2 == 2) {
         this.name = var1.readStringCp1252NullTerminated();
      } else if(var2 == 4) {
         this.zoom2d = var1.__ag_302();
      } else if(var2 == 5) {
         this.xan2d = var1.__ag_302();
      } else if(var2 == 6) {
         this.yan2d = var1.__ag_302();
      } else if(var2 == 7) {
         this.offsetX2d = var1.__ag_302();
         if(this.offsetX2d > 32767) {
            this.offsetX2d -= 65536;
         }
      } else if(var2 == 8) {
         this.offsetY2d = var1.__ag_302();
         if(this.offsetY2d > 32767) {
            this.offsetY2d -= 65536;
         }
      } else if(var2 == 11) {
         this.isStackable = 1;
      } else if(var2 == 12) {
         this.price = var1.readInt();
      } else if(var2 == 16) {
         this.isMembersOnly = true;
      } else if(var2 == 23) {
         this.maleModel = var1.__ag_302();
         this.maleOffset = var1.readUnsignedByte();
      } else if(var2 == 24) {
         this.maleModel1 = var1.__ag_302();
      } else if(var2 == 25) {
         this.femaleModel = var1.__ag_302();
         this.femaleOffset = var1.readUnsignedByte();
      } else if(var2 == 26) {
         this.femaleModel1 = var1.__ag_302();
      } else if(var2 >= 30 && var2 < 35) {
         this.groundActions[var2 - 30] = var1.readStringCp1252NullTerminated();
         if(this.groundActions[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.groundActions[var2 - 30] = null;
         }
      } else if(var2 >= 35 && var2 < 40) {
         this.inventoryActions[var2 - 35] = var1.readStringCp1252NullTerminated();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.readUnsignedByte();
            this.recolorFrom = new short[var3];
            this.recolorTo = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.recolorFrom[var4] = (short)var1.__ag_302();
               this.recolorTo[var4] = (short)var1.__ag_302();
            }
         } else if(var2 == 41) {
            var3 = var1.readUnsignedByte();
            this.retextureFrom = new short[var3];
            this.retextureTo = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.retextureFrom[var4] = (short)var1.__ag_302();
               this.retextureTo[var4] = (short)var1.__ag_302();
            }
         } else if(var2 == 42) {
            this.shiftClickIndex0 = var1.readByte();
         } else if(var2 == 65) {
            this.isTradable = true;
         } else if(var2 == 78) {
            this.maleModel2 = var1.__ag_302();
         } else if(var2 == 79) {
            this.femaleModel2 = var1.__ag_302();
         } else if(var2 == 90) {
            this.maleHeadModel = var1.__ag_302();
         } else if(var2 == 91) {
            this.femaleHeadModel = var1.__ag_302();
         } else if(var2 == 92) {
            this.maleHeadModel2 = var1.__ag_302();
         } else if(var2 == 93) {
            this.femaleHeadModel2 = var1.__ag_302();
         } else if(var2 == 95) {
            this.zan2d = var1.__ag_302();
         } else if(var2 == 97) {
            this.note = var1.__ag_302();
         } else if(var2 == 98) {
            this.noteTemplate = var1.__ag_302();
         } else if(var2 >= 100 && var2 < 110) {
            if(this.__az == null) {
               this.__az = new int[10];
               this.__au = new int[10];
            }

            this.__az[var2 - 100] = var1.__ag_302();
            this.__au[var2 - 100] = var1.__ag_302();
         } else if(var2 == 110) {
            this.resizeX = var1.__ag_302();
         } else if(var2 == 111) {
            this.resizeY = var1.__ag_302();
         } else if(var2 == 112) {
            this.resizeZ = var1.__ag_302();
         } else if(var2 == 113) {
            this.ambient = var1.readByte();
         } else if(var2 == 114) {
            this.contrast = var1.readByte();
         } else if(var2 == 115) {
            this.int1 = var1.readUnsignedByte();
         } else if(var2 == 139) {
            this.unnotedId = var1.__ag_302();
         } else if(var2 == 140) {
            this.notedId = var1.__ag_302();
         } else if(var2 == 148) {
            this.placeholder = var1.__ag_302();
         } else if(var2 == 149) {
            this.placeholderTemplate = var1.__ag_302();
         } else if(var2 == 249) {
            this.params = AbstractIndexCache.readStringIntParameters(var1, this.params);
         }
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljv;Ljv;I)V",
      garbageValue = "2051877377"
   )
   @Export("__o_426")
   void __o_426(ItemDefinition var1, ItemDefinition var2) {
      this.__a = var1.__a;
      this.zoom2d = var1.zoom2d;
      this.xan2d = var1.xan2d;
      this.yan2d = var1.yan2d;
      this.zan2d = var1.zan2d;
      this.offsetX2d = var1.offsetX2d;
      this.offsetY2d = var1.offsetY2d;
      this.recolorFrom = var1.recolorFrom;
      this.recolorTo = var1.recolorTo;
      this.retextureFrom = var1.retextureFrom;
      this.retextureTo = var1.retextureTo;
      this.name = var2.name;
      this.isMembersOnly = var2.isMembersOnly;
      this.price = var2.price;
      this.isStackable = 1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(Ljv;Ljv;I)V",
      garbageValue = "227754762"
   )
   @Export("__u_427")
   void __u_427(ItemDefinition var1, ItemDefinition var2) {
      this.__a = var1.__a;
      this.zoom2d = var1.zoom2d;
      this.xan2d = var1.xan2d;
      this.yan2d = var1.yan2d;
      this.zan2d = var1.zan2d;
      this.offsetX2d = var1.offsetX2d;
      this.offsetY2d = var1.offsetY2d;
      this.recolorFrom = var2.recolorFrom;
      this.recolorTo = var2.recolorTo;
      this.retextureFrom = var2.retextureFrom;
      this.retextureTo = var2.retextureTo;
      this.name = var2.name;
      this.isMembersOnly = var2.isMembersOnly;
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

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljv;Ljv;I)V",
      garbageValue = "2084647027"
   )
   @Export("__g_428")
   void __g_428(ItemDefinition var1, ItemDefinition var2) {
      this.__a = var1.__a;
      this.zoom2d = var1.zoom2d;
      this.xan2d = var1.xan2d;
      this.yan2d = var1.yan2d;
      this.zan2d = var1.zan2d;
      this.offsetX2d = var1.offsetX2d;
      this.offsetY2d = var1.offsetY2d;
      this.recolorFrom = var1.recolorFrom;
      this.recolorTo = var1.recolorTo;
      this.retextureFrom = var1.retextureFrom;
      this.retextureTo = var1.retextureTo;
      this.isStackable = var1.isStackable;
      this.name = var2.name;
      this.price = 0;
      this.isMembersOnly = false;
      this.isTradable = false;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)Ldw;",
      garbageValue = "-223149161"
   )
   @Export("__l_429")
   public final ModelData __l_429(int var1) {
      int var2;
      if(this.__az != null && var1 > 1) {
         int var3 = -1;

         for(var2 = 0; var2 < 10; ++var2) {
            if(var1 >= this.__au[var2] && this.__au[var2] != 0) {
               var3 = this.__az[var2];
            }
         }

         if(var3 != -1) {
            return Skills.getItemDefinition(var3).__l_429(1);
         }
      }

      ModelData var4 = ModelData.method2788(ItemDefinition_modelIndexCache, this.__a, 0);
      if(var4 == null) {
         return null;
      } else {
         if(this.resizeX != 128 || this.resizeY != 128 || this.resizeZ != 128) {
            var4.__y_227(this.resizeX, this.resizeY, this.resizeZ);
         }

         if(this.recolorFrom != null) {
            for(var2 = 0; var2 < this.recolorFrom.length; ++var2) {
               var4.recolor(this.recolorFrom[var2], this.recolorTo[var2]);
            }
         }

         if(this.retextureFrom != null) {
            for(var2 = 0; var2 < this.retextureFrom.length; ++var2) {
               var4.retexture(this.retextureFrom[var2], this.retextureTo[var2]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(II)Ldu;",
      garbageValue = "1152916563"
   )
   @Export("getModel")
   public final Model getModel(int var1) {
      if(this.__az != null && var1 > 1) {
         int var2 = -1;

         for(int var3 = 0; var3 < 10; ++var3) {
            if(var1 >= this.__au[var3] && this.__au[var3] != 0) {
               var2 = this.__az[var3];
            }
         }

         if(var2 != -1) {
            return Skills.getItemDefinition(var2).getModel(1);
         }
      }

      Model var5 = (Model)ItemDefinition_cachedModels.get((long)this.id);
      if(var5 != null) {
         return var5;
      } else {
         ModelData var6 = ModelData.method2788(ItemDefinition_modelIndexCache, this.__a, 0);
         if(var6 == null) {
            return null;
         } else {
            if(this.resizeX != 128 || this.resizeY != 128 || this.resizeZ != 128) {
               var6.__y_227(this.resizeX, this.resizeY, this.resizeZ);
            }

            int var4;
            if(this.recolorFrom != null) {
               for(var4 = 0; var4 < this.recolorFrom.length; ++var4) {
                  var6.recolor(this.recolorFrom[var4], this.recolorTo[var4]);
               }
            }

            if(this.retextureFrom != null) {
               for(var4 = 0; var4 < this.retextureFrom.length; ++var4) {
                  var6.retexture(this.retextureFrom[var4], this.retextureTo[var4]);
               }
            }

            var5 = var6.toModel(this.ambient + 64, this.contrast * 5 + 768, -50, -10, -50);
            var5.isSingleTile = true;
            ItemDefinition_cachedModels.put(var5, (long)this.id);
            return var5;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IB)Ljv;",
      garbageValue = "0"
   )
   @Export("__x_430")
   public ItemDefinition __x_430(int var1) {
      if(this.__az != null && var1 > 1) {
         int var2 = -1;

         for(int var3 = 0; var3 < 10; ++var3) {
            if(var1 >= this.__au[var3] && this.__au[var3] != 0) {
               var2 = this.__az[var3];
            }
         }

         if(var2 != -1) {
            return Skills.getItemDefinition(var2);
         }
      }

      return this;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(ZI)Z",
      garbageValue = "-918880706"
   )
   @Export("__z_431")
   public final boolean __z_431(boolean var1) {
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

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(ZB)Ldw;",
      garbageValue = "-123"
   )
   @Export("__j_432")
   public final ModelData __j_432(boolean var1) {
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
         ModelData var5 = ModelData.method2788(ItemDefinition_modelIndexCache, var2, 0);
         if(var3 != -1) {
            ModelData var6 = ModelData.method2788(ItemDefinition_modelIndexCache, var3, 0);
            if(var4 != -1) {
               ModelData var7 = ModelData.method2788(ItemDefinition_modelIndexCache, var4, 0);
               ModelData[] var8 = new ModelData[]{var5, var6, var7};
               var5 = new ModelData(var8, 3);
            } else {
               ModelData[] var10 = new ModelData[]{var5, var6};
               var5 = new ModelData(var10, 2);
            }
         }

         if(!var1 && this.maleOffset != 0) {
            var5.__z_225(0, this.maleOffset, 0);
         }

         if(var1 && this.femaleOffset != 0) {
            var5.__z_225(0, this.femaleOffset, 0);
         }

         int var9;
         if(this.recolorFrom != null) {
            for(var9 = 0; var9 < this.recolorFrom.length; ++var9) {
               var5.recolor(this.recolorFrom[var9], this.recolorTo[var9]);
            }
         }

         if(this.retextureFrom != null) {
            for(var9 = 0; var9 < this.retextureFrom.length; ++var9) {
               var5.retexture(this.retextureFrom[var9], this.retextureTo[var9]);
            }
         }

         return var5;
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ZI)Z",
      garbageValue = "-998582497"
   )
   @Export("__s_433")
   public final boolean __s_433(boolean var1) {
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

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(ZI)Ldw;",
      garbageValue = "-1820885439"
   )
   @Export("__t_434")
   public final ModelData __t_434(boolean var1) {
      int var2 = this.maleHeadModel;
      int var3 = this.maleHeadModel2;
      if(var1) {
         var2 = this.femaleHeadModel;
         var3 = this.femaleHeadModel2;
      }

      if(var2 == -1) {
         return null;
      } else {
         ModelData var4 = ModelData.method2788(ItemDefinition_modelIndexCache, var2, 0);
         if(var3 != -1) {
            ModelData var5 = ModelData.method2788(ItemDefinition_modelIndexCache, var3, 0);
            ModelData[] var6 = new ModelData[]{var4, var5};
            var4 = new ModelData(var6, 2);
         }

         int var7;
         if(this.recolorFrom != null) {
            for(var7 = 0; var7 < this.recolorFrom.length; ++var7) {
               var4.recolor(this.recolorFrom[var7], this.recolorTo[var7]);
            }
         }

         if(this.retextureFrom != null) {
            for(var7 = 0; var7 < this.retextureFrom.length; ++var7) {
               var4.retexture(this.retextureFrom[var7], this.retextureTo[var7]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IIS)I",
      garbageValue = "8781"
   )
   @Export("getIntParam")
   public int getIntParam(int var1, int var2) {
      IterableNodeHashTable var3 = this.params;
      int var4;
      if(var3 == null) {
         var4 = var2;
      } else {
         IntegerNode var5 = (IntegerNode)var3.get((long)var1);
         if(var5 == null) {
            var4 = var2;
         } else {
            var4 = var5.integer;
         }
      }

      return var4;
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "471693065"
   )
   @Export("getStringParam")
   public String getStringParam(int var1, String var2) {
      return Frames.method3238(this.params, var1, var2);
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1665022672"
   )
   @Export("getShiftClickIndex")
   public int getShiftClickIndex() {
      return this.shiftClickIndex0 != -1 && this.inventoryActions != null?(this.shiftClickIndex0 >= 0?(this.inventoryActions[this.shiftClickIndex0] != null?this.shiftClickIndex0:-1):("Drop".equalsIgnoreCase(this.inventoryActions[4])?4:-1)):-1;
   }

   static {
      ItemDefinition_cached = new EvictingDualNodeHashTable(64);
      ItemDefinition_cachedModels = new EvictingDualNodeHashTable(50);
      Sprite_cached = new EvictingDualNodeHashTable(200);
   }
}
