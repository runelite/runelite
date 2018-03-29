import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ip")
@Implements("PlayerComposition")
public class PlayerComposition {
   @ObfuscatedName("z")
   @Export("colorsToFind")
   public static short[] colorsToFind;
   @ObfuscatedName("w")
   public static short[] field2787;
   @ObfuscatedName("r")
   public static short[][] field2780;
   @ObfuscatedName("d")
   static final int[] field2789;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "Lhj;"
   )
   public static NodeCache field2785;
   @ObfuscatedName("bt")
   @ObfuscatedGetter(
      intValue = -1156960017
   )
   static int field2791;
   @ObfuscatedName("c")
   @Export("equipmentIds")
   int[] equipmentIds;
   @ObfuscatedName("i")
   @Export("bodyPartColours")
   int[] bodyPartColours;
   @ObfuscatedName("o")
   @Export("isFemale")
   public boolean isFemale;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1540355509
   )
   @Export("transformedNpcId")
   public int transformedNpcId;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      longValue = 3250398404253519497L
   )
   @Export("hash")
   long hash;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      longValue = -7138781834569065177L
   )
   long field2786;

   static {
      field2789 = new int[]{8, 11, 4, 6, 9, 7, 10};
      field2785 = new NodeCache(260);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "([I[IZIB)V",
      garbageValue = "59"
   )
   public void method4408(int[] var1, int[] var2, boolean var3, int var4) {
      if(var1 == null) {
         var1 = new int[12];

         for(int var5 = 0; var5 < 7; ++var5) {
            for(int var6 = 0; var6 < KitDefinition.field3512; ++var6) {
               KitDefinition var7 = VarCString.getKitDefinition(var6);
               if(var7 != null && !var7.nonSelectable && var7.bodyPartId == var5 + (var3?7:0)) {
                  var1[field2789[var5]] = var6 + 256;
                  break;
               }
            }
         }
      }

      this.equipmentIds = var1;
      this.bodyPartColours = var2;
      this.isFemale = var3;
      this.transformedNpcId = var4;
      this.setHash();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(IZB)V",
      garbageValue = "124"
   )
   public void method4409(int var1, boolean var2) {
      if(var1 != 1 || !this.isFemale) {
         int var3 = this.equipmentIds[field2789[var1]];
         if(var3 != 0) {
            var3 -= 256;

            KitDefinition var4;
            do {
               if(!var2) {
                  --var3;
                  if(var3 < 0) {
                     var3 = KitDefinition.field3512 - 1;
                  }
               } else {
                  ++var3;
                  if(var3 >= KitDefinition.field3512) {
                     var3 = 0;
                  }
               }

               var4 = VarCString.getKitDefinition(var3);
            } while(var4 == null || var4.nonSelectable || var4.bodyPartId != (this.isFemale?7:0) + var1);

            this.equipmentIds[field2789[var1]] = var3 + 256;
            this.setHash();
         }
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IZB)V",
      garbageValue = "4"
   )
   public void method4410(int var1, boolean var2) {
      int var3 = this.bodyPartColours[var1];
      if(!var2) {
         do {
            --var3;
            if(var3 < 0) {
               var3 = GameCanvas.colorsToReplace[var1].length - 1;
            }
         } while(!IndexDataBase.method4595(var1, var3));
      } else {
         do {
            ++var3;
            if(var3 >= GameCanvas.colorsToReplace[var1].length) {
               var3 = 0;
            }
         } while(!IndexDataBase.method4595(var1, var3));
      }

      this.bodyPartColours[var1] = var3;
      this.setHash();
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "-33"
   )
   public void method4411(boolean var1) {
      if(this.isFemale != var1) {
         this.method4408((int[])null, this.bodyPartColours, var1, -1);
      }
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lgp;B)V",
      garbageValue = "1"
   )
   public void method4412(Buffer var1) {
      var1.putByte(this.isFemale?1:0);

      int var2;
      for(var2 = 0; var2 < 7; ++var2) {
         int var3 = this.equipmentIds[field2789[var2]];
         if(var3 == 0) {
            var1.putByte(-1);
         } else {
            var1.putByte(var3 - 256);
         }
      }

      for(var2 = 0; var2 < 5; ++var2) {
         var1.putByte(this.bodyPartColours[var2]);
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-1"
   )
   @Export("setHash")
   void setHash() {
      long var1 = this.hash;
      int var3 = this.equipmentIds[5];
      int var4 = this.equipmentIds[9];
      this.equipmentIds[5] = var4;
      this.equipmentIds[9] = var3;
      this.hash = 0L;

      int var5;
      for(var5 = 0; var5 < 12; ++var5) {
         this.hash <<= 4;
         if(this.equipmentIds[var5] >= 256) {
            this.hash += (long)(this.equipmentIds[var5] - 256);
         }
      }

      if(this.equipmentIds[0] >= 256) {
         this.hash += (long)(this.equipmentIds[0] - 256 >> 4);
      }

      if(this.equipmentIds[1] >= 256) {
         this.hash += (long)(this.equipmentIds[1] - 256 >> 8);
      }

      for(var5 = 0; var5 < 5; ++var5) {
         this.hash <<= 3;
         this.hash += (long)this.bodyPartColours[var5];
      }

      this.hash <<= 1;
      this.hash += (long)(this.isFemale?1:0);
      this.equipmentIds[5] = var3;
      this.equipmentIds[9] = var4;
      if(var1 != 0L && var1 != this.hash) {
         field2785.remove(var1);
      }

   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lkn;ILkn;II)Led;",
      garbageValue = "980120878"
   )
   @Export("getModel")
   public Model getModel(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.transformedNpcId != -1) {
         return ScriptEvent.getNpcDefinition(this.transformedNpcId).getModel(var1, var2, var3, var4);
      } else {
         long var5 = this.hash;
         int[] var7 = this.equipmentIds;
         if(var1 != null && (var1.leftHandItem >= 0 || var1.rightHandItem >= 0)) {
            var7 = new int[12];

            for(int var8 = 0; var8 < 12; ++var8) {
               var7[var8] = this.equipmentIds[var8];
            }

            if(var1.leftHandItem >= 0) {
               var5 += (long)(var1.leftHandItem - this.equipmentIds[5] << 40);
               var7[5] = var1.leftHandItem;
            }

            if(var1.rightHandItem >= 0) {
               var5 += (long)(var1.rightHandItem - this.equipmentIds[3] << 48);
               var7[3] = var1.rightHandItem;
            }
         }

         Model var15 = (Model)field2785.get(var5);
         if(var15 == null) {
            boolean var9 = false;

            int var11;
            for(int var10 = 0; var10 < 12; ++var10) {
               var11 = var7[var10];
               if(var11 >= 256 && var11 < 512 && !VarCString.getKitDefinition(var11 - 256).ready()) {
                  var9 = true;
               }

               if(var11 >= 512 && !GameObject.getItemDefinition(var11 - 512).readyWorn(this.isFemale)) {
                  var9 = true;
               }
            }

            if(var9) {
               if(-1L != this.field2786) {
                  var15 = (Model)field2785.get(this.field2786);
               }

               if(var15 == null) {
                  return null;
               }
            }

            if(var15 == null) {
               ModelData[] var16 = new ModelData[12];
               var11 = 0;

               int var13;
               for(int var12 = 0; var12 < 12; ++var12) {
                  var13 = var7[var12];
                  ModelData var14;
                  if(var13 >= 256 && var13 < 512) {
                     var14 = VarCString.getKitDefinition(var13 - 256).getModelData();
                     if(var14 != null) {
                        var16[var11++] = var14;
                     }
                  }

                  if(var13 >= 512) {
                     var14 = GameObject.getItemDefinition(var13 - 512).getWornModelData(this.isFemale);
                     if(var14 != null) {
                        var16[var11++] = var14;
                     }
                  }
               }

               ModelData var18 = new ModelData(var16, var11);

               for(var13 = 0; var13 < 5; ++var13) {
                  if(this.bodyPartColours[var13] < GameCanvas.colorsToReplace[var13].length) {
                     var18.recolor(colorsToFind[var13], GameCanvas.colorsToReplace[var13][this.bodyPartColours[var13]]);
                  }

                  if(this.bodyPartColours[var13] < field2780[var13].length) {
                     var18.recolor(field2787[var13], field2780[var13][this.bodyPartColours[var13]]);
                  }
               }

               var15 = var18.light(64, 850, -30, -50, -30);
               field2785.put(var15, var5);
               this.field2786 = var5;
            }
         }

         if(var1 == null && var3 == null) {
            return var15;
         } else {
            Model var17;
            if(var1 != null && var3 != null) {
               var17 = var1.applyTransformations(var15, var2, var3, var4);
            } else if(var1 != null) {
               var17 = var1.transformActorModel(var15, var2);
            } else {
               var17 = var3.transformActorModel(var15, var4);
            }

            return var17;
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(I)Ldj;",
      garbageValue = "1413726174"
   )
   ModelData method4434() {
      if(this.transformedNpcId != -1) {
         return ScriptEvent.getNpcDefinition(this.transformedNpcId).method5126();
      } else {
         boolean var1 = false;

         int var3;
         for(int var2 = 0; var2 < 12; ++var2) {
            var3 = this.equipmentIds[var2];
            if(var3 >= 256 && var3 < 512 && !VarCString.getKitDefinition(var3 - 256).method4835()) {
               var1 = true;
            }

            if(var3 >= 512 && !GameObject.getItemDefinition(var3 - 512).method5064(this.isFemale)) {
               var1 = true;
            }
         }

         if(var1) {
            return null;
         } else {
            ModelData[] var7 = new ModelData[12];
            var3 = 0;

            int var5;
            for(int var4 = 0; var4 < 12; ++var4) {
               var5 = this.equipmentIds[var4];
               ModelData var6;
               if(var5 >= 256 && var5 < 512) {
                  var6 = VarCString.getKitDefinition(var5 - 256).method4836();
                  if(var6 != null) {
                     var7[var3++] = var6;
                  }
               }

               if(var5 >= 512) {
                  var6 = GameObject.getItemDefinition(var5 - 512).method5066(this.isFemale);
                  if(var6 != null) {
                     var7[var3++] = var6;
                  }
               }
            }

            ModelData var8 = new ModelData(var7, var3);

            for(var5 = 0; var5 < 5; ++var5) {
               if(this.bodyPartColours[var5] < GameCanvas.colorsToReplace[var5].length) {
                  var8.recolor(colorsToFind[var5], GameCanvas.colorsToReplace[var5][this.bodyPartColours[var5]]);
               }

               if(this.bodyPartColours[var5] < field2780[var5].length) {
                  var8.recolor(field2787[var5], field2780[var5][this.bodyPartColours[var5]]);
               }
            }

            return var8;
         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "-1348673710"
   )
   public int method4416() {
      return this.transformedNpcId == -1?(this.equipmentIds[0] << 15) + this.equipmentIds[1] + (this.equipmentIds[11] << 5) + (this.equipmentIds[8] << 10) + (this.bodyPartColours[0] << 25) + (this.bodyPartColours[4] << 20):305419896 + ScriptEvent.getNpcDefinition(this.transformedNpcId).id;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(ILfa;Ljs;B)V",
      garbageValue = "100"
   )
   static void method4436(int var0, IndexFile var1, IndexData var2) {
      byte[] var3 = null;
      Deque var4 = IndexStoreActionHandler.IndexStoreActionHandler_requestQueue;
      synchronized(IndexStoreActionHandler.IndexStoreActionHandler_requestQueue) {
         for(FileSystem var5 = (FileSystem)IndexStoreActionHandler.IndexStoreActionHandler_requestQueue.getFront(); var5 != null; var5 = (FileSystem)IndexStoreActionHandler.IndexStoreActionHandler_requestQueue.getNext()) {
            if((long)var0 == var5.hash && var1 == var5.index && var5.type == 0) {
               var3 = var5.field3356;
               break;
            }
         }
      }

      if(var3 != null) {
         var2.load(var1, var0, var3, true);
      } else {
         byte[] var8 = var1.read(var0);
         var2.load(var1, var0, var8, true);
      }
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(ILcx;ZB)I",
      garbageValue = "1"
   )
   static int method4435(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 == 2700) {
         var3 = class3.getWidget(class81.intStack[--SceneTilePaint.intStackSize]);
         class81.intStack[++SceneTilePaint.intStackSize - 1] = var3.itemId;
         return 1;
      } else if(var0 == 2701) {
         var3 = class3.getWidget(class81.intStack[--SceneTilePaint.intStackSize]);
         if(var3.itemId != -1) {
            class81.intStack[++SceneTilePaint.intStackSize - 1] = var3.itemQuantity;
         } else {
            class81.intStack[++SceneTilePaint.intStackSize - 1] = 0;
         }

         return 1;
      } else if(var0 == 2702) {
         int var5 = class81.intStack[--SceneTilePaint.intStackSize];
         WidgetNode var4 = (WidgetNode)Client.componentTable.get((long)var5);
         if(var4 != null) {
            class81.intStack[++SceneTilePaint.intStackSize - 1] = 1;
         } else {
            class81.intStack[++SceneTilePaint.intStackSize - 1] = 0;
         }

         return 1;
      } else if(var0 == 2706) {
         class81.intStack[++SceneTilePaint.intStackSize - 1] = Client.widgetRoot;
         return 1;
      } else {
         return 2;
      }
   }
}
