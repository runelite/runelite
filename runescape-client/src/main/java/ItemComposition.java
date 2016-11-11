import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("by")
@Implements("ItemComposition")
public class ItemComposition extends CacheableNode {
   @ObfuscatedName("m")
   @Export("itemModelCache")
   public static NodeCache itemModelCache = new NodeCache(50);
   @ObfuscatedName("w")
   short[] field1165;
   @ObfuscatedName("n")
   public static class170 field1166;
   @ObfuscatedName("l")
   public static NodeCache field1167 = new NodeCache(64);
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = -508281881
   )
   int field1168 = -1;
   @ObfuscatedName("j")
   @Export("itemSpriteCache")
   public static NodeCache itemSpriteCache = new NodeCache(200);
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 504704291
   )
   @Export("id")
   public int id;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -993361439
   )
   int field1171;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = -1447061619
   )
   @Export("maleModel")
   int maleModel = -1;
   @ObfuscatedName("r")
   short[] field1173;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = 1274572547
   )
   public int field1174 = 0;
   @ObfuscatedName("aj")
   @ObfuscatedGetter(
      intValue = 561578009
   )
   int field1176 = 128;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = -1792258321
   )
   public int field1177 = 2000;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 564003377
   )
   public int field1178 = 0;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = -40538941
   )
   public int field1179 = 0;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1030748739
   )
   public int field1180 = 0;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      intValue = -988743553
   )
   public int field1181 = 0;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 1304603335
   )
   public int field1182 = 0;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 152146073
   )
   @Export("isStackable")
   public int isStackable = 0;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = 1575488797
   )
   int field1184 = -1;
   @ObfuscatedName("bv")
   @ObfuscatedGetter(
      intValue = 2021616435
   )
   int field1185 = -1;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1358455099
   )
   @Export("price")
   public int price = 1;
   @ObfuscatedName("as")
   @Export("groundActions")
   public String[] groundActions = new String[]{null, null, "Take", null, null};
   @ObfuscatedName("af")
   @ObfuscatedGetter(
      intValue = -2003442035
   )
   int field1188 = -1;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -222890857
   )
   int field1189 = -1;
   @ObfuscatedName("am")
   @Export("isMembers")
   public boolean isMembers = false;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = -491936125
   )
   int field1191 = -1;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 1017133587
   )
   int field1192 = -1;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 1910483079
   )
   int field1193 = 0;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 46960581
   )
   int field1195 = -1;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 1692875025
   )
   int field1196 = 0;
   @ObfuscatedName("ah")
   @ObfuscatedGetter(
      intValue = -1739501805
   )
   int field1197 = -1;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = -1078127315
   )
   int field1198 = -1;
   @ObfuscatedName("bb")
   static class171 field1199;
   @ObfuscatedName("ac")
   int[] field1200;
   @ObfuscatedName("ai")
   int[] field1201;
   @ObfuscatedName("x")
   short[] field1202;
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = -449686939
   )
   public int field1203 = -1;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -895746297
   )
   int field1204 = 128;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -367240351
   )
   int field1205 = 128;
   @ObfuscatedName("c")
   short[] field1206;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -2105125939
   )
   @Export("note")
   public int note = -1;
   @ObfuscatedName("ad")
   @Export("inventoryActions")
   public String[] inventoryActions = new String[]{null, null, null, null, "Drop"};
   @ObfuscatedName("ae")
   @ObfuscatedGetter(
      intValue = -704832795
   )
   public int field1209 = 0;
   @ObfuscatedName("at")
   public boolean field1210 = false;
   @ObfuscatedName("bc")
   @ObfuscatedGetter(
      intValue = 1328389833
   )
   int field1211 = -1;
   @ObfuscatedName("by")
   @ObfuscatedGetter(
      intValue = -1037771211
   )
   public int field1212 = -1;
   @ObfuscatedName("bi")
   @ObfuscatedGetter(
      intValue = 1520807731
   )
   public int field1213 = -1;
   @ObfuscatedName("ds")
   @ObfuscatedGetter(
      intValue = 945978813
   )
   static int field1214;
   @ObfuscatedName("v")
   @Export("name")
   public String name = "null";
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = -563289115
   )
   public int field1216 = 0;
   @ObfuscatedName("kw")
   static class134 field1217;

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "701328904"
   )
   @Export("loadBuffer")
   void loadBuffer(Buffer var1) {
      while(true) {
         int var2 = var1.method2544();
         if(var2 == 0) {
            return;
         }

         this.populateFromBuffer(var1, var2);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LBuffer;IB)V",
      garbageValue = "0"
   )
   @Export("populateFromBuffer")
   void populateFromBuffer(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field1171 = var1.method2546();
      } else if(var2 == 2) {
         this.name = var1.method2552();
      } else if(var2 == 4) {
         this.field1177 = var1.method2546();
      } else if(var2 == 5) {
         this.field1178 = var1.method2546();
      } else if(var2 == 6) {
         this.field1179 = var1.method2546();
      } else if(var2 == 7) {
         this.field1181 = var1.method2546();
         if(this.field1181 > 32767) {
            this.field1181 -= 65536;
         }
      } else if(var2 == 8) {
         this.field1182 = var1.method2546();
         if(this.field1182 > 32767) {
            this.field1182 -= 65536;
         }
      } else if(var2 == 11) {
         this.isStackable = 1;
      } else if(var2 == 12) {
         this.price = var1.method2549();
      } else if(var2 == 16) {
         this.isMembers = true;
      } else if(var2 == 23) {
         this.field1188 = var1.method2546();
         this.field1196 = var1.method2544();
      } else if(var2 == 24) {
         this.field1189 = var1.method2546();
      } else if(var2 == 25) {
         this.field1191 = var1.method2546();
         this.field1193 = var1.method2544();
      } else if(var2 == 26) {
         this.field1192 = var1.method2546();
      } else if(var2 >= 30 && var2 < 35) {
         this.groundActions[var2 - 30] = var1.method2552();
         if(this.groundActions[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.groundActions[var2 - 30] = null;
         }
      } else if(var2 >= 35 && var2 < 40) {
         this.inventoryActions[var2 - 35] = var1.method2552();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.method2544();
            this.field1173 = new short[var3];
            this.field1206 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1173[var4] = (short)var1.method2546();
               this.field1206[var4] = (short)var1.method2546();
            }
         } else if(var2 == 41) {
            var3 = var1.method2544();
            this.field1165 = new short[var3];
            this.field1202 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1165[var4] = (short)var1.method2546();
               this.field1202[var4] = (short)var1.method2546();
            }
         } else if(var2 == 65) {
            this.field1210 = true;
         } else if(var2 == 78) {
            this.field1184 = var1.method2546();
         } else if(var2 == 79) {
            this.field1195 = var1.method2546();
         } else if(var2 == 90) {
            this.maleModel = var1.method2546();
         } else if(var2 == 91) {
            this.field1198 = var1.method2546();
         } else if(var2 == 92) {
            this.field1197 = var1.method2546();
         } else if(var2 == 93) {
            this.field1168 = var1.method2546();
         } else if(var2 == 95) {
            this.field1180 = var1.method2546();
         } else if(var2 == 97) {
            this.note = var1.method2546();
         } else if(var2 == 98) {
            this.field1203 = var1.method2546();
         } else if(var2 >= 100 && var2 < 110) {
            if(null == this.field1200) {
               this.field1200 = new int[10];
               this.field1201 = new int[10];
            }

            this.field1200[var2 - 100] = var1.method2546();
            this.field1201[var2 - 100] = var1.method2546();
         } else if(var2 == 110) {
            this.field1204 = var1.method2546();
         } else if(var2 == 111) {
            this.field1205 = var1.method2546();
         } else if(var2 == 112) {
            this.field1176 = var1.method2546();
         } else if(var2 == 113) {
            this.field1216 = var1.method2545();
         } else if(var2 == 114) {
            this.field1174 = var1.method2545() * 5;
         } else if(var2 == 115) {
            this.field1209 = var1.method2544();
         } else if(var2 == 139) {
            this.field1211 = var1.method2546();
         } else if(var2 == 140) {
            this.field1185 = var1.method2546();
         } else if(var2 == 148) {
            this.field1213 = var1.method2546();
         } else if(var2 == 149) {
            this.field1212 = var1.method2546();
         }
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(LItemComposition;LItemComposition;B)V",
      garbageValue = "52"
   )
   void method1118(ItemComposition var1, ItemComposition var2) {
      this.field1171 = var1.field1171;
      this.field1177 = var1.field1177;
      this.field1178 = var1.field1178;
      this.field1179 = var1.field1179;
      this.field1180 = var1.field1180;
      this.field1181 = var1.field1181;
      this.field1182 = var1.field1182;
      this.field1173 = var2.field1173;
      this.field1206 = var2.field1206;
      this.field1165 = var2.field1165;
      this.field1202 = var2.field1202;
      this.name = var2.name;
      this.isMembers = var2.isMembers;
      this.isStackable = var2.isStackable;
      this.field1188 = var2.field1188;
      this.field1189 = var2.field1189;
      this.field1184 = var2.field1184;
      this.field1191 = var2.field1191;
      this.field1192 = var2.field1192;
      this.field1195 = var2.field1195;
      this.maleModel = var2.maleModel;
      this.field1197 = var2.field1197;
      this.field1198 = var2.field1198;
      this.field1168 = var2.field1168;
      this.field1209 = var2.field1209;
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

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(LItemComposition;LItemComposition;I)V",
      garbageValue = "426408384"
   )
   void method1119(ItemComposition var1, ItemComposition var2) {
      this.field1171 = var1.field1171;
      this.field1177 = var1.field1177;
      this.field1178 = var1.field1178;
      this.field1179 = var1.field1179;
      this.field1180 = var1.field1180;
      this.field1181 = var1.field1181;
      this.field1182 = var1.field1182;
      this.field1173 = var1.field1173;
      this.field1206 = var1.field1206;
      this.field1165 = var1.field1165;
      this.field1202 = var1.field1202;
      this.isStackable = var1.isStackable;
      this.name = var2.name;
      this.price = 0;
      this.isMembers = false;
      this.field1210 = false;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(II)LModelData;",
      garbageValue = "-270139237"
   )
   public final ModelData method1120(int var1) {
      int var3;
      if(this.field1200 != null && var1 > 1) {
         int var2 = -1;

         for(var3 = 0; var3 < 10; ++var3) {
            if(var1 >= this.field1201[var3] && this.field1201[var3] != 0) {
               var2 = this.field1200[var3];
            }
         }

         if(var2 != -1) {
            return class92.getItemDefinition(var2).method1120(1);
         }
      }

      ModelData var4 = ModelData.method2245(field1166, this.field1171, 0);
      if(null == var4) {
         return null;
      } else {
         if(this.field1204 != 128 || this.field1205 != 128 || this.field1176 != 128) {
            var4.method2260(this.field1204, this.field1205, this.field1176);
         }

         if(this.field1173 != null) {
            for(var3 = 0; var3 < this.field1173.length; ++var3) {
               var4.method2315(this.field1173[var3], this.field1206[var3]);
            }
         }

         if(this.field1165 != null) {
            for(var3 = 0; var3 < this.field1165.length; ++var3) {
               var4.method2258(this.field1165[var3], this.field1202[var3]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(II)LItemComposition;",
      garbageValue = "-2129015606"
   )
   public ItemComposition method1122(int var1) {
      if(null != this.field1200 && var1 > 1) {
         int var2 = -1;

         for(int var3 = 0; var3 < 10; ++var3) {
            if(var1 >= this.field1201[var3] && this.field1201[var3] != 0) {
               var2 = this.field1200[var3];
            }
         }

         if(var2 != -1) {
            return class92.getItemDefinition(var2);
         }
      }

      return this;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ZI)Z",
      garbageValue = "-701085007"
   )
   @Export("readyWorn")
   public final boolean readyWorn(boolean var1) {
      int var2 = this.field1188;
      int var3 = this.field1189;
      int var4 = this.field1184;
      if(var1) {
         var2 = this.field1191;
         var3 = this.field1192;
         var4 = this.field1195;
      }

      if(var2 == -1) {
         return true;
      } else {
         boolean var5 = true;
         if(!field1166.method3291(var2, 0)) {
            var5 = false;
         }

         if(var3 != -1 && !field1166.method3291(var3, 0)) {
            var5 = false;
         }

         if(var4 != -1 && !field1166.method3291(var4, 0)) {
            var5 = false;
         }

         return var5;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ZB)LModelData;",
      garbageValue = "-73"
   )
   @Export("getWornModelData")
   public final ModelData getWornModelData(boolean var1) {
      int var2 = this.field1188;
      int var3 = this.field1189;
      int var4 = this.field1184;
      if(var1) {
         var2 = this.field1191;
         var3 = this.field1192;
         var4 = this.field1195;
      }

      if(var2 == -1) {
         return null;
      } else {
         ModelData var5 = ModelData.method2245(field1166, var2, 0);
         if(var3 != -1) {
            ModelData var9 = ModelData.method2245(field1166, var3, 0);
            if(var4 != -1) {
               ModelData var7 = ModelData.method2245(field1166, var4, 0);
               ModelData[] var8 = new ModelData[]{var5, var9, var7};
               var5 = new ModelData(var8, 3);
            } else {
               ModelData[] var10 = new ModelData[]{var5, var9};
               var5 = new ModelData(var10, 2);
            }
         }

         if(!var1 && this.field1196 != 0) {
            var5.method2250(0, this.field1196, 0);
         }

         if(var1 && this.field1193 != 0) {
            var5.method2250(0, this.field1193, 0);
         }

         int var6;
         if(this.field1173 != null) {
            for(var6 = 0; var6 < this.field1173.length; ++var6) {
               var5.method2315(this.field1173[var6], this.field1206[var6]);
            }
         }

         if(null != this.field1165) {
            for(var6 = 0; var6 < this.field1165.length; ++var6) {
               var5.method2258(this.field1165[var6], this.field1202[var6]);
            }
         }

         return var5;
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1508183984"
   )
   void method1134() {
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ZS)LModelData;",
      garbageValue = "22712"
   )
   public final ModelData method1135(boolean var1) {
      int var2 = this.maleModel;
      int var3 = this.field1197;
      if(var1) {
         var2 = this.field1198;
         var3 = this.field1168;
      }

      if(var2 == -1) {
         return null;
      } else {
         ModelData var4 = ModelData.method2245(field1166, var2, 0);
         if(var3 != -1) {
            ModelData var7 = ModelData.method2245(field1166, var3, 0);
            ModelData[] var6 = new ModelData[]{var4, var7};
            var4 = new ModelData(var6, 2);
         }

         int var5;
         if(null != this.field1173) {
            for(var5 = 0; var5 < this.field1173.length; ++var5) {
               var4.method2315(this.field1173[var5], this.field1206[var5]);
            }
         }

         if(null != this.field1165) {
            for(var5 = 0; var5 < this.field1165.length; ++var5) {
               var4.method2258(this.field1165[var5], this.field1202[var5]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(ZI)Z",
      garbageValue = "376072264"
   )
   public final boolean method1145(boolean var1) {
      int var2 = this.maleModel;
      int var3 = this.field1197;
      if(var1) {
         var2 = this.field1198;
         var3 = this.field1168;
      }

      if(var2 == -1) {
         return true;
      } else {
         boolean var4 = true;
         if(!field1166.method3291(var2, 0)) {
            var4 = false;
         }

         if(var3 != -1 && !field1166.method3291(var3, 0)) {
            var4 = false;
         }

         return var4;
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(IB)LModel;",
      garbageValue = "6"
   )
   @Export("getModel")
   public final Model getModel(int var1) {
      if(null != this.field1200 && var1 > 1) {
         int var2 = -1;

         for(int var5 = 0; var5 < 10; ++var5) {
            if(var1 >= this.field1201[var5] && this.field1201[var5] != 0) {
               var2 = this.field1200[var5];
            }
         }

         if(var2 != -1) {
            return class92.getItemDefinition(var2).getModel(1);
         }
      }

      Model var6 = (Model)itemModelCache.get((long)this.id);
      if(null != var6) {
         return var6;
      } else {
         ModelData var3 = ModelData.method2245(field1166, this.field1171, 0);
         if(null == var3) {
            return null;
         } else {
            if(this.field1204 != 128 || this.field1205 != 128 || this.field1176 != 128) {
               var3.method2260(this.field1204, this.field1205, this.field1176);
            }

            int var4;
            if(null != this.field1173) {
               for(var4 = 0; var4 < this.field1173.length; ++var4) {
                  var3.method2315(this.field1173[var4], this.field1206[var4]);
               }
            }

            if(this.field1165 != null) {
               for(var4 = 0; var4 < this.field1165.length; ++var4) {
                  var3.method2258(this.field1165[var4], this.field1202[var4]);
               }
            }

            var6 = var3.method2265(64 + this.field1216, this.field1174 + 768, -50, -10, -50);
            var6.field1881 = true;
            itemModelCache.put(var6, (long)this.id);
            return var6;
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(LItemComposition;LItemComposition;B)V",
      garbageValue = "-41"
   )
   void method1164(ItemComposition var1, ItemComposition var2) {
      this.field1171 = var1.field1171;
      this.field1177 = var1.field1177;
      this.field1178 = var1.field1178;
      this.field1179 = var1.field1179;
      this.field1180 = var1.field1180;
      this.field1181 = var1.field1181;
      this.field1182 = var1.field1182;
      this.field1173 = var1.field1173;
      this.field1206 = var1.field1206;
      this.field1165 = var1.field1165;
      this.field1202 = var1.field1202;
      this.name = var2.name;
      this.isMembers = var2.isMembers;
      this.price = var2.price;
      this.isStackable = 1;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1695715294"
   )
   public static void method1166() {
      class49.field1091.reset();
      class49.field1081.reset();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "8"
   )
   static void method1167() {
      class33.username = class33.username.trim();
      if(class33.username.length() == 0) {
         class5.method88("Please enter your username.", "If you created your account after November", "2010, this will be the creation email address.");
      } else {
         long var1 = class51.method1060();
         int var0;
         if(0L == var1) {
            var0 = 5;
         } else {
            var0 = ChatLineBuffer.method646(var1, class33.username);
         }

         switch(var0) {
         case 2:
            class5.method88("", "Page has opened in a new window.", "(Please check your popup blocker.)");
            class33.loginIndex = 6;
            break;
         case 3:
            class5.method88("", "Error connecting to server.", "");
            break;
         case 4:
            class5.method88("The part of the website you are trying", "to connect to is offline at the moment.", "Please try again later.");
            break;
         case 5:
            class5.method88("Sorry, there was an error trying to", "log you in to this part of the website.", "Please try again later.");
            break;
         case 6:
            class5.method88("", "Error connecting to server.", "");
            break;
         case 7:
            class5.method88("You must enter a valid login to proceed. For accounts", "created after 24th November 2010, please use your", "email address. Otherwise please use your username.");
         }

      }
   }

   @ObfuscatedName("cl")
   @ObfuscatedSignature(
      signature = "(IIIZI)V",
      garbageValue = "2124968476"
   )
   static final void method1168(int var0, int var1, int var2, boolean var3) {
      if(class14.method172(var0)) {
         class14.method166(Widget.widgets[var0], -1, var1, var2, var3);
      }
   }
}
