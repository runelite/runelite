import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hi")
@Implements("PlayerAppearance")
public class PlayerAppearance {
   @ObfuscatedName("g")
   @Export("__hi_g")
   public static short[] __hi_g;
   @ObfuscatedName("d")
   @Export("__hi_d")
   static final int[] __hi_d;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Ler;"
   )
   @Export("PlayerAppearance_cachedModels")
   public static EvictingDualNodeHashTable PlayerAppearance_cachedModels;
   @ObfuscatedName("m")
   @Export("equipment")
   int[] equipment;
   @ObfuscatedName("f")
   @Export("bodyColors")
   int[] bodyColors;
   @ObfuscatedName("q")
   @Export("isFemale")
   public boolean isFemale;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1676934923
   )
   @Export("npcTransformId")
   public int npcTransformId;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      longValue = -3506189412688081513L
   )
   @Export("__o")
   long __o;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      longValue = 8217880921734028425L
   )
   @Export("__u")
   long __u;

   static {
      __hi_d = new int[]{8, 11, 4, 6, 9, 7, 10};
      PlayerAppearance_cachedModels = new EvictingDualNodeHashTable(260);
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "([I[IZII)V",
      garbageValue = "727056871"
   )
   @Export("__m_385")
   public void __m_385(int[] var1, int[] var2, boolean var3, int var4) {
      if(var1 == null) {
         var1 = new int[12];

         for(int var5 = 0; var5 < 7; ++var5) {
            for(int var6 = 0; var6 < KitDefinition.__im_q; ++var6) {
               KitDefinition var7 = WorldMapSection1.getKitDefinition(var6);
               if(var7 != null && !var7.__k && var5 + (var3?7:0) == var7.__o) {
                  var1[__hi_d[var5]] = var6 + 256;
                  break;
               }
            }
         }
      }

      this.equipment = var1;
      this.bodyColors = var2;
      this.isFemale = var3;
      this.npcTransformId = var4;
      this.setHash();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "-581016899"
   )
   @Export("__f_386")
   public void __f_386(int var1, boolean var2) {
      if(var1 != 1 || !this.isFemale) {
         int var3 = this.equipment[__hi_d[var1]];
         if(var3 != 0) {
            var3 -= 256;

            KitDefinition var4;
            do {
               if(!var2) {
                  --var3;
                  if(var3 < 0) {
                     var3 = KitDefinition.__im_q - 1;
                  }
               } else {
                  ++var3;
                  if(var3 >= KitDefinition.__im_q) {
                     var3 = 0;
                  }
               }

               var4 = WorldMapSection1.getKitDefinition(var3);
            } while(var4 == null || var4.__k || var1 + (this.isFemale?7:0) != var4.__o);

            this.equipment[__hi_d[var1]] = var3 + 256;
            this.setHash();
         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "1416503110"
   )
   @Export("__q_387")
   public void __q_387(int var1, boolean var2) {
      int var3 = this.bodyColors[var1];
      if(!var2) {
         do {
            --var3;
            if(var3 < 0) {
               var3 = class229.__hz_l[var1].length - 1;
            }
         } while(!PacketBuffer.method4062(var1, var3));
      } else {
         do {
            ++var3;
            if(var3 >= class229.__hz_l[var1].length) {
               var3 = 0;
            }
         } while(!PacketBuffer.method4062(var1, var3));
      }

      this.bodyColors[var1] = var3;
      this.setHash();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "-90"
   )
   @Export("__w_388")
   public void __w_388(boolean var1) {
      if(this.isFemale != var1) {
         this.__m_385((int[])null, this.bodyColors, var1, -1);
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Lgr;I)V",
      garbageValue = "779254645"
   )
   @Export("__o_389")
   public void __o_389(Buffer var1) {
      var1.writeByte(this.isFemale?1:0);

      int var2;
      for(var2 = 0; var2 < 7; ++var2) {
         int var3 = this.equipment[__hi_d[var2]];
         if(var3 == 0) {
            var1.writeByte(-1);
         } else {
            var1.writeByte(var3 - 256);
         }
      }

      for(var2 = 0; var2 < 5; ++var2) {
         var1.writeByte(this.bodyColors[var2]);
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "68"
   )
   @Export("setHash")
   void setHash() {
      long var1 = this.__o;
      int var3 = this.equipment[5];
      int var4 = this.equipment[9];
      this.equipment[5] = var4;
      this.equipment[9] = var3;
      this.__o = 0L;

      int var5;
      for(var5 = 0; var5 < 12; ++var5) {
         this.__o <<= 4;
         if(this.equipment[var5] >= 256) {
            this.__o += (long)(this.equipment[var5] - 256);
         }
      }

      if(this.equipment[0] >= 256) {
         this.__o += (long)(this.equipment[0] - 256 >> 4);
      }

      if(this.equipment[1] >= 256) {
         this.__o += (long)(this.equipment[1] - 256 >> 8);
      }

      for(var5 = 0; var5 < 5; ++var5) {
         this.__o <<= 3;
         this.__o += (long)this.bodyColors[var5];
      }

      this.__o <<= 1;
      this.__o += (long)(this.isFemale?1:0);
      this.equipment[5] = var3;
      this.equipment[9] = var4;
      if(var1 != 0L && this.__o != var1) {
         PlayerAppearance_cachedModels.remove(var1);
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljh;ILjh;II)Ldu;",
      garbageValue = "-735725541"
   )
   @Export("getModel")
   public Model getModel(SequenceDefinition var1, int var2, SequenceDefinition var3, int var4) {
      if(this.npcTransformId != -1) {
         return ObjectDefinition.getNpcDefinition(this.npcTransformId).getModel(var1, var2, var3, var4);
      } else {
         long var5 = this.__o;
         int[] var7 = this.equipment;
         if(var1 != null && (var1.shield >= 0 || var1.weapon >= 0)) {
            var7 = new int[12];

            for(int var15 = 0; var15 < 12; ++var15) {
               var7[var15] = this.equipment[var15];
            }

            if(var1.shield >= 0) {
               var5 += (long)(var1.shield - this.equipment[5] << 40);
               var7[5] = var1.shield;
            }

            if(var1.weapon >= 0) {
               var5 += (long)(var1.weapon - this.equipment[3] << 48);
               var7[3] = var1.weapon;
            }
         }

         Model var8 = (Model)PlayerAppearance_cachedModels.get(var5);
         if(var8 == null) {
            boolean var9 = false;

            int var11;
            for(int var10 = 0; var10 < 12; ++var10) {
               var11 = var7[var10];
               if(var11 >= 256 && var11 < 512 && !WorldMapSection1.getKitDefinition(var11 - 256).__w_413()) {
                  var9 = true;
               }

               if(var11 >= 512 && !Skills.getItemDefinition(var11 - 512).__z_431(this.isFemale)) {
                  var9 = true;
               }
            }

            if(var9) {
               if(this.__u != -1L) {
                  var8 = (Model)PlayerAppearance_cachedModels.get(this.__u);
               }

               if(var8 == null) {
                  return null;
               }
            }

            if(var8 == null) {
               ModelData[] var16 = new ModelData[12];
               var11 = 0;

               int var13;
               for(int var12 = 0; var12 < 12; ++var12) {
                  var13 = var7[var12];
                  ModelData var14;
                  if(var13 >= 256 && var13 < 512) {
                     var14 = WorldMapSection1.getKitDefinition(var13 - 256).__o_414();
                     if(var14 != null) {
                        var16[var11++] = var14;
                     }
                  }

                  if(var13 >= 512) {
                     var14 = Skills.getItemDefinition(var13 - 512).__j_432(this.isFemale);
                     if(var14 != null) {
                        var16[var11++] = var14;
                     }
                  }
               }

               ModelData var18 = new ModelData(var16, var11);

               for(var13 = 0; var13 < 5; ++var13) {
                  if(this.bodyColors[var13] < class229.__hz_l[var13].length) {
                     var18.recolor(__hi_g[var13], class229.__hz_l[var13][this.bodyColors[var13]]);
                  }

                  if(this.bodyColors[var13] < IndexCacheLoader.__bd_x[var13].length) {
                     var18.recolor(class227.__hj_e[var13], IndexCacheLoader.__bd_x[var13][this.bodyColors[var13]]);
                  }
               }

               var8 = var18.toModel(64, 850, -30, -50, -30);
               PlayerAppearance_cachedModels.put(var8, var5);
               this.__u = var5;
            }
         }

         if(var1 == null && var3 == null) {
            return var8;
         } else {
            Model var17;
            if(var1 != null && var3 != null) {
               var17 = var1.animateSequence2(var8, var2, var3, var4);
            } else if(var1 != null) {
               var17 = var1.animateSequence(var8, var2);
            } else {
               var17 = var3.animateSequence(var8, var4);
            }

            return var17;
         }
      }
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Ldw;",
      garbageValue = "1807737418"
   )
   @Export("getModelData")
   ModelData getModelData() {
      if(this.npcTransformId != -1) {
         return ObjectDefinition.getNpcDefinition(this.npcTransformId).getModelData();
      } else {
         boolean var1 = false;

         int var3;
         for(int var2 = 0; var2 < 12; ++var2) {
            var3 = this.equipment[var2];
            if(var3 >= 256 && var3 < 512 && !WorldMapSection1.getKitDefinition(var3 - 256).__u_415()) {
               var1 = true;
            }

            if(var3 >= 512 && !Skills.getItemDefinition(var3 - 512).__s_433(this.isFemale)) {
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
               var5 = this.equipment[var4];
               ModelData var6;
               if(var5 >= 256 && var5 < 512) {
                  var6 = WorldMapSection1.getKitDefinition(var5 - 256).__g_416();
                  if(var6 != null) {
                     var7[var3++] = var6;
                  }
               }

               if(var5 >= 512) {
                  var6 = Skills.getItemDefinition(var5 - 512).__t_434(this.isFemale);
                  if(var6 != null) {
                     var7[var3++] = var6;
                  }
               }
            }

            ModelData var8 = new ModelData(var7, var3);

            for(var5 = 0; var5 < 5; ++var5) {
               if(this.bodyColors[var5] < class229.__hz_l[var5].length) {
                  var8.recolor(__hi_g[var5], class229.__hz_l[var5][this.bodyColors[var5]]);
               }

               if(this.bodyColors[var5] < IndexCacheLoader.__bd_x[var5].length) {
                  var8.recolor(class227.__hj_e[var5], IndexCacheLoader.__bd_x[var5][this.bodyColors[var5]]);
               }
            }

            return var8;
         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(B)I",
      garbageValue = "123"
   )
   @Export("getChatHeadId")
   public int getChatHeadId() {
      return this.npcTransformId == -1?(this.equipment[0] << 15) + this.equipment[1] + (this.equipment[11] << 5) + (this.equipment[8] << 10) + (this.bodyColors[0] << 25) + (this.bodyColors[4] << 20):305419896 + ObjectDefinition.getNpcDefinition(this.npcTransformId).id;
   }
}
