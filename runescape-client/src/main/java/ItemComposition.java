import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bg")
@Implements("ItemComposition")
public class ItemComposition extends CacheableNode {
   @ObfuscatedName("ae")
   @Export("isMembers")
   public boolean isMembers = false;
   @ObfuscatedName("y")
   static class170 field1142;
   @ObfuscatedName("p")
   static class170 field1143;
   @ObfuscatedName("al")
   @ObfuscatedGetter(
      intValue = 718186693
   )
   int field1144 = 128;
   @ObfuscatedName("k")
   @Export("itemModelCache")
   static NodeCache itemModelCache = new NodeCache(50);
   @ObfuscatedName("h")
   @Export("itemSpriteCache")
   static NodeCache itemSpriteCache = new NodeCache(200);
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1981523037
   )
   @Export("id")
   public int id;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      intValue = -979871427
   )
   int field1149;
   @ObfuscatedName("n")
   @Export("name")
   public String name = "null";
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = -1235577641
   )
   public int field1151 = 2000;
   @ObfuscatedName("r")
   static class227 field1152;
   @ObfuscatedName("d")
   short[] field1153;
   @ObfuscatedName("bg")
   @ObfuscatedGetter(
      intValue = -1134072149
   )
   public int field1154 = -1;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -88312627
   )
   public int field1155 = 0;
   @ObfuscatedName("ac")
   @ObfuscatedGetter(
      intValue = 1682189977
   )
   int field1156 = 0;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 649326595
   )
   public int field1157 = 0;
   @ObfuscatedName("az")
   @ObfuscatedGetter(
      intValue = 1851592437
   )
   @Export("note")
   public int note = -1;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1958498605
   )
   public int field1159 = 0;
   @ObfuscatedName("a")
   short[] field1160;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -1638960697
   )
   @Export("isStackable")
   public int isStackable = 0;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1460471377
   )
   @Export("price")
   public int price = 1;
   @ObfuscatedName("f")
   static NodeCache field1163 = new NodeCache(64);
   @ObfuscatedName("ah")
   @Export("groundActions")
   public String[] groundActions = new String[]{null, null, "Take", null, null};
   @ObfuscatedName("am")
   @Export("inventoryActions")
   public String[] inventoryActions = new String[]{null, null, null, null, "Drop"};
   @ObfuscatedName("aa")
   @ObfuscatedGetter(
      intValue = 643818545
   )
   int field1166 = -1;
   @ObfuscatedName("ax")
   @ObfuscatedGetter(
      intValue = 803519495
   )
   int field1167 = -1;
   @ObfuscatedName("as")
   @ObfuscatedGetter(
      intValue = -1616196537
   )
   public int field1168 = 0;
   @ObfuscatedName("ar")
   @ObfuscatedGetter(
      intValue = 1494170449
   )
   int field1169 = -1;
   @ObfuscatedName("an")
   @ObfuscatedGetter(
      intValue = 2071256649
   )
   int field1170 = -1;
   @ObfuscatedName("ab")
   @ObfuscatedGetter(
      intValue = -878974263
   )
   int field1171 = -1;
   @ObfuscatedName("ao")
   @ObfuscatedGetter(
      intValue = 883056613
   )
   int field1173 = -1;
   @ObfuscatedName("ag")
   @ObfuscatedGetter(
      intValue = 1074058117
   )
   int field1174 = 0;
   @ObfuscatedName("ap")
   @ObfuscatedGetter(
      intValue = -630392137
   )
   int field1175 = -1;
   @ObfuscatedName("au")
   @ObfuscatedGetter(
      intValue = -817292843
   )
   int field1176 = -1;
   @ObfuscatedName("ad")
   @ObfuscatedGetter(
      intValue = -2078441191
   )
   int field1177 = -1;
   @ObfuscatedName("aj")
   int[] field1178;
   @ObfuscatedName("ai")
   int[] field1179;
   @ObfuscatedName("b")
   short[] field1180;
   @ObfuscatedName("ay")
   @ObfuscatedGetter(
      intValue = -1715040747
   )
   public int field1181 = -1;
   @ObfuscatedName("at")
   @ObfuscatedGetter(
      intValue = -1154144133
   )
   int field1182 = 128;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1530795621
   )
   public int field1183 = 0;
   @ObfuscatedName("aw")
   @ObfuscatedGetter(
      intValue = 1989990267
   )
   int field1184 = 128;
   @ObfuscatedName("av")
   @ObfuscatedGetter(
      intValue = -1825722115
   )
   @Export("maleModel")
   int maleModel = -1;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 527197137
   )
   public int field1186 = 0;
   @ObfuscatedName("aq")
   @ObfuscatedGetter(
      intValue = 904870797
   )
   public int field1187 = 0;
   @ObfuscatedName("af")
   public boolean field1188 = false;
   @ObfuscatedName("bp")
   @ObfuscatedGetter(
      intValue = 1792014887
   )
   int field1189 = -1;
   @ObfuscatedName("bh")
   @ObfuscatedGetter(
      intValue = -650500617
   )
   int field1190 = -1;
   @ObfuscatedName("bo")
   @ObfuscatedGetter(
      intValue = 1002788081
   )
   public int field1191 = -1;
   @ObfuscatedName("q")
   short[] field1192;
   @ObfuscatedName("ak")
   @ObfuscatedGetter(
      intValue = -31092809
   )
   public int field1193 = 0;
   @ObfuscatedName("ib")
   static Widget field1196;

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(IZIZI)V",
      garbageValue = "1235998715"
   )
   static void method1077(int var0, boolean var1, int var2, boolean var3) {
      if(World.worldList != null) {
         class144.method2971(0, World.worldList.length - 1, var0, var1, var2, var3);
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1780307908"
   )
   void method1078() {
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(LBuffer;B)V",
      garbageValue = "20"
   )
   @Export("loadBuffer")
   void loadBuffer(Buffer var1) {
      while(true) {
         int var2 = var1.method2481();
         if(var2 == 0) {
            return;
         }

         this.populateFromBuffer(var1, var2);
      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(LItemComposition;LItemComposition;I)V",
      garbageValue = "-716908270"
   )
   void method1082(ItemComposition var1, ItemComposition var2) {
      this.field1149 = var1.field1149;
      this.field1151 = var1.field1151;
      this.field1183 = var1.field1183;
      this.field1157 = var1.field1157;
      this.field1159 = var1.field1159;
      this.field1155 = var1.field1155;
      this.field1186 = var1.field1186;
      this.field1153 = var2.field1153;
      this.field1160 = var2.field1160;
      this.field1180 = var2.field1180;
      this.field1192 = var2.field1192;
      this.name = var2.name;
      this.isMembers = var2.isMembers;
      this.isStackable = var2.isStackable;
      this.field1166 = var2.field1166;
      this.field1167 = var2.field1167;
      this.field1171 = var2.field1171;
      this.field1169 = var2.field1169;
      this.field1170 = var2.field1170;
      this.field1173 = var2.field1173;
      this.maleModel = var2.maleModel;
      this.field1175 = var2.field1175;
      this.field1176 = var2.field1176;
      this.field1177 = var2.field1177;
      this.field1187 = var2.field1187;
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

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(LItemComposition;LItemComposition;I)V",
      garbageValue = "-389252028"
   )
   void method1083(ItemComposition var1, ItemComposition var2) {
      this.field1149 = var1.field1149;
      this.field1151 = var1.field1151;
      this.field1183 = var1.field1183;
      this.field1157 = var1.field1157;
      this.field1159 = var1.field1159;
      this.field1155 = var1.field1155;
      this.field1186 = var1.field1186;
      this.field1153 = var1.field1153;
      this.field1160 = var1.field1160;
      this.field1180 = var1.field1180;
      this.field1192 = var1.field1192;
      this.isStackable = var1.isStackable;
      this.name = var2.name;
      this.price = 0;
      this.isMembers = false;
      this.field1188 = false;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(II)LModelData;",
      garbageValue = "1298444092"
   )
   public final ModelData method1084(int var1) {
      int var3;
      if(this.field1178 != null && var1 > 1) {
         int var2 = -1;

         for(var3 = 0; var3 < 10; ++var3) {
            if(var1 >= this.field1179[var3] && this.field1179[var3] != 0) {
               var2 = this.field1178[var3];
            }
         }

         if(var2 != -1) {
            return class174.getItemDefinition(var2).method1084(1);
         }
      }

      ModelData var4 = ModelData.method2184(field1143, this.field1149, 0);
      if(var4 == null) {
         return null;
      } else {
         if(this.field1182 != 128 || this.field1144 != 128 || this.field1184 != 128) {
            var4.method2198(this.field1182, this.field1144, this.field1184);
         }

         if(null != this.field1153) {
            for(var3 = 0; var3 < this.field1153.length; ++var3) {
               var4.method2197(this.field1153[var3], this.field1160[var3]);
            }
         }

         if(this.field1180 != null) {
            for(var3 = 0; var3 < this.field1180.length; ++var3) {
               var4.method2234(this.field1180[var3], this.field1192[var3]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(ZI)LModelData;",
      garbageValue = "1818114592"
   )
   public final ModelData method1085(boolean var1) {
      int var2 = this.maleModel;
      int var3 = this.field1175;
      if(var1) {
         var2 = this.field1176;
         var3 = this.field1177;
      }

      if(var2 == -1) {
         return null;
      } else {
         ModelData var4 = ModelData.method2184(field1143, var2, 0);
         if(var3 != -1) {
            ModelData var7 = ModelData.method2184(field1143, var3, 0);
            ModelData[] var6 = new ModelData[]{var4, var7};
            var4 = new ModelData(var6, 2);
         }

         int var5;
         if(this.field1153 != null) {
            for(var5 = 0; var5 < this.field1153.length; ++var5) {
               var4.method2197(this.field1153[var5], this.field1160[var5]);
            }
         }

         if(this.field1180 != null) {
            for(var5 = 0; var5 < this.field1180.length; ++var5) {
               var4.method2234(this.field1180[var5], this.field1192[var5]);
            }
         }

         return var4;
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(IS)LItemComposition;",
      garbageValue = "32767"
   )
   public ItemComposition method1086(int var1) {
      if(null != this.field1178 && var1 > 1) {
         int var2 = -1;

         for(int var3 = 0; var3 < 10; ++var3) {
            if(var1 >= this.field1179[var3] && this.field1179[var3] != 0) {
               var2 = this.field1178[var3];
            }
         }

         if(var2 != -1) {
            return class174.getItemDefinition(var2);
         }
      }

      return this;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(ZB)Z",
      garbageValue = "-17"
   )
   @Export("readyWorn")
   public final boolean readyWorn(boolean var1) {
      int var2 = this.field1166;
      int var3 = this.field1167;
      int var4 = this.field1171;
      if(var1) {
         var2 = this.field1169;
         var3 = this.field1170;
         var4 = this.field1173;
      }

      if(var2 == -1) {
         return true;
      } else {
         boolean var5 = true;
         if(!field1143.method3252(var2, 0)) {
            var5 = false;
         }

         if(var3 != -1 && !field1143.method3252(var3, 0)) {
            var5 = false;
         }

         if(var4 != -1 && !field1143.method3252(var4, 0)) {
            var5 = false;
         }

         return var5;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(ZI)LModelData;",
      garbageValue = "-2142340891"
   )
   @Export("getWornModelData")
   public final ModelData getWornModelData(boolean var1) {
      int var2 = this.field1166;
      int var3 = this.field1167;
      int var4 = this.field1171;
      if(var1) {
         var2 = this.field1169;
         var3 = this.field1170;
         var4 = this.field1173;
      }

      if(var2 == -1) {
         return null;
      } else {
         ModelData var5 = ModelData.method2184(field1143, var2, 0);
         if(var3 != -1) {
            ModelData var9 = ModelData.method2184(field1143, var3, 0);
            if(var4 != -1) {
               ModelData var7 = ModelData.method2184(field1143, var4, 0);
               ModelData[] var8 = new ModelData[]{var5, var9, var7};
               var5 = new ModelData(var8, 3);
            } else {
               ModelData[] var10 = new ModelData[]{var5, var9};
               var5 = new ModelData(var10, 2);
            }
         }

         if(!var1 && this.field1156 != 0) {
            var5.method2191(0, this.field1156, 0);
         }

         if(var1 && this.field1174 != 0) {
            var5.method2191(0, this.field1174, 0);
         }

         int var6;
         if(null != this.field1153) {
            for(var6 = 0; var6 < this.field1153.length; ++var6) {
               var5.method2197(this.field1153[var6], this.field1160[var6]);
            }
         }

         if(null != this.field1180) {
            for(var6 = 0; var6 < this.field1180.length; ++var6) {
               var5.method2234(this.field1180[var6], this.field1192[var6]);
            }
         }

         return var5;
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ZI)Z",
      garbageValue = "-1771906844"
   )
   public final boolean method1089(boolean var1) {
      int var2 = this.maleModel;
      int var3 = this.field1175;
      if(var1) {
         var2 = this.field1176;
         var3 = this.field1177;
      }

      if(var2 == -1) {
         return true;
      } else {
         boolean var4 = true;
         if(!field1143.method3252(var2, 0)) {
            var4 = false;
         }

         if(var3 != -1 && !field1143.method3252(var3, 0)) {
            var4 = false;
         }

         return var4;
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(LBuffer;II)V",
      garbageValue = "1663559703"
   )
   @Export("populateFromBuffer")
   void populateFromBuffer(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field1149 = var1.method2668();
      } else if(var2 == 2) {
         this.name = var1.method2503();
      } else if(var2 == 4) {
         this.field1151 = var1.method2668();
      } else if(var2 == 5) {
         this.field1183 = var1.method2668();
      } else if(var2 == 6) {
         this.field1157 = var1.method2668();
      } else if(var2 == 7) {
         this.field1155 = var1.method2668();
         if(this.field1155 > 32767) {
            this.field1155 -= 65536;
         }
      } else if(var2 == 8) {
         this.field1186 = var1.method2668();
         if(this.field1186 > 32767) {
            this.field1186 -= 65536;
         }
      } else if(var2 == 11) {
         this.isStackable = 1;
      } else if(var2 == 12) {
         this.price = var1.method2526();
      } else if(var2 == 16) {
         this.isMembers = true;
      } else if(var2 == 23) {
         this.field1166 = var1.method2668();
         this.field1156 = var1.method2481();
      } else if(var2 == 24) {
         this.field1167 = var1.method2668();
      } else if(var2 == 25) {
         this.field1169 = var1.method2668();
         this.field1174 = var1.method2481();
      } else if(var2 == 26) {
         this.field1170 = var1.method2668();
      } else if(var2 >= 30 && var2 < 35) {
         this.groundActions[var2 - 30] = var1.method2503();
         if(this.groundActions[var2 - 30].equalsIgnoreCase("Hidden")) {
            this.groundActions[var2 - 30] = null;
         }
      } else if(var2 >= 35 && var2 < 40) {
         this.inventoryActions[var2 - 35] = var1.method2503();
      } else {
         int var3;
         int var4;
         if(var2 == 40) {
            var3 = var1.method2481();
            this.field1153 = new short[var3];
            this.field1160 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1153[var4] = (short)var1.method2668();
               this.field1160[var4] = (short)var1.method2668();
            }
         } else if(var2 == 41) {
            var3 = var1.method2481();
            this.field1180 = new short[var3];
            this.field1192 = new short[var3];

            for(var4 = 0; var4 < var3; ++var4) {
               this.field1180[var4] = (short)var1.method2668();
               this.field1192[var4] = (short)var1.method2668();
            }
         } else if(var2 == 65) {
            this.field1188 = true;
         } else if(var2 == 78) {
            this.field1171 = var1.method2668();
         } else if(var2 == 79) {
            this.field1173 = var1.method2668();
         } else if(var2 == 90) {
            this.maleModel = var1.method2668();
         } else if(var2 == 91) {
            this.field1176 = var1.method2668();
         } else if(var2 == 92) {
            this.field1175 = var1.method2668();
         } else if(var2 == 93) {
            this.field1177 = var1.method2668();
         } else if(var2 == 95) {
            this.field1159 = var1.method2668();
         } else if(var2 == 97) {
            this.note = var1.method2668();
         } else if(var2 == 98) {
            this.field1181 = var1.method2668();
         } else if(var2 >= 100 && var2 < 110) {
            if(this.field1178 == null) {
               this.field1178 = new int[10];
               this.field1179 = new int[10];
            }

            this.field1178[var2 - 100] = var1.method2668();
            this.field1179[var2 - 100] = var1.method2668();
         } else if(var2 == 110) {
            this.field1182 = var1.method2668();
         } else if(var2 == 111) {
            this.field1144 = var1.method2668();
         } else if(var2 == 112) {
            this.field1184 = var1.method2668();
         } else if(var2 == 113) {
            this.field1193 = var1.method2601();
         } else if(var2 == 114) {
            this.field1168 = var1.method2601() * 5;
         } else if(var2 == 115) {
            this.field1187 = var1.method2481();
         } else if(var2 == 139) {
            this.field1189 = var1.method2668();
         } else if(var2 == 140) {
            this.field1190 = var1.method2668();
         } else if(var2 == 148) {
            this.field1191 = var1.method2668();
         } else if(var2 == 149) {
            this.field1154 = var1.method2668();
         }
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LSequence;IIIB)V",
      garbageValue = "-87"
   )
   static void method1124(Sequence var0, int var1, int var2, int var3) {
      if(Client.field510 < 50 && Client.field303 != 0) {
         if(var0.field976 != null && var1 < var0.field976.length) {
            int var4 = var0.field976[var1];
            if(var4 != 0) {
               int var5 = var4 >> 8;
               int var6 = var4 >> 4 & 7;
               int var7 = var4 & 15;
               Client.field511[Client.field510] = var5;
               Client.field315[Client.field510] = var6;
               Client.field482[Client.field510] = 0;
               Client.field515[Client.field510] = null;
               int var8 = (var2 - 64) / 128;
               int var9 = (var3 - 64) / 128;
               Client.field514[Client.field510] = var7 + (var9 << 8) + (var8 << 16);
               ++Client.field510;
            }
         }
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IB)LModel;",
      garbageValue = "37"
   )
   @Export("getModel")
   public final Model getModel(int var1) {
      if(this.field1178 != null && var1 > 1) {
         int var2 = -1;

         for(int var5 = 0; var5 < 10; ++var5) {
            if(var1 >= this.field1179[var5] && this.field1179[var5] != 0) {
               var2 = this.field1178[var5];
            }
         }

         if(var2 != -1) {
            return class174.getItemDefinition(var2).getModel(1);
         }
      }

      Model var6 = (Model)itemModelCache.get((long)this.id);
      if(null != var6) {
         return var6;
      } else {
         ModelData var3 = ModelData.method2184(field1143, this.field1149, 0);
         if(var3 == null) {
            return null;
         } else {
            if(this.field1182 != 128 || this.field1144 != 128 || this.field1184 != 128) {
               var3.method2198(this.field1182, this.field1144, this.field1184);
            }

            int var4;
            if(null != this.field1153) {
               for(var4 = 0; var4 < this.field1153.length; ++var4) {
                  var3.method2197(this.field1153[var4], this.field1160[var4]);
               }
            }

            if(null != this.field1180) {
               for(var4 = 0; var4 < this.field1180.length; ++var4) {
                  var3.method2234(this.field1180[var4], this.field1192[var4]);
               }
            }

            var6 = var3.method2203(64 + this.field1193, this.field1168 + 768, -50, -10, -50);
            var6.field1864 = true;
            itemModelCache.put(var6, (long)this.id);
            return var6;
         }
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(LItemComposition;LItemComposition;I)V",
      garbageValue = "1408593469"
   )
   void method1131(ItemComposition var1, ItemComposition var2) {
      this.field1149 = var1.field1149;
      this.field1151 = var1.field1151;
      this.field1183 = var1.field1183;
      this.field1157 = var1.field1157;
      this.field1159 = var1.field1159;
      this.field1155 = var1.field1155;
      this.field1186 = var1.field1186;
      this.field1153 = var1.field1153;
      this.field1160 = var1.field1160;
      this.field1180 = var1.field1180;
      this.field1192 = var1.field1192;
      this.name = var2.name;
      this.isMembers = var2.isMembers;
      this.price = var2.price;
      this.isStackable = 1;
   }
}
