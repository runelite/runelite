import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hu")
@Implements("PlayerComposition")
public class PlayerComposition {
   @ObfuscatedName("m")
   static final int[] field2624;
   @ObfuscatedName("u")
   public static NodeCache field2627;
   @ObfuscatedName("l")
   @Export("colorsToFind")
   public static short[] colorsToFind;
   @ObfuscatedName("w")
   public static short[] field2621;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 330740351
   )
   @Export("transformedNpcId")
   public int transformedNpcId;
   @ObfuscatedName("j")
   @Export("bodyPartColours")
   int[] bodyPartColours;
   @ObfuscatedName("n")
   @Export("isFemale")
   public boolean isFemale;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      longValue = -2627207055115822303L
   )
   @Export("hash")
   long hash;
   @ObfuscatedName("a")
   @Export("equipmentIds")
   int[] equipmentIds;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      longValue = -3055585771193194799L
   )
   long field2623;

   static {
      field2624 = new int[]{8, 11, 4, 6, 9, 7, 10};
      field2627 = new NodeCache(260);
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "([I[IZII)V",
      garbageValue = "-2032808093"
   )
   public void method3934(int[] var1, int[] var2, boolean var3, int var4) {
      if(var1 == null) {
         var1 = new int[12];

         for(int var5 = 0; var5 < 7; ++var5) {
            for(int var6 = 0; var6 < KitDefinition.field3352; ++var6) {
               KitDefinition var7 = FloorUnderlayDefinition.getKitDefinition(var6);
               if(var7 != null && !var7.nonSelectable && var7.bodyPartId == (var3?7:0) + var5) {
                  var1[field2624[var5]] = var6 + 256;
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

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1716368626"
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
      if(0L != var1 && this.hash != var1) {
         field2627.remove(var1);
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(LSequence;ILSequence;IB)LModel;",
      garbageValue = "127"
   )
   public Model method3940(Sequence var1, int var2, Sequence var3, int var4) {
      if(this.transformedNpcId != -1) {
         return class224.getNpcDefinition(this.transformedNpcId).method4570(var1, var2, var3, var4);
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

         Model var15 = (Model)field2627.get(var5);
         if(var15 == null) {
            boolean var9 = false;

            int var11;
            for(int var10 = 0; var10 < 12; ++var10) {
               var11 = var7[var10];
               if(var11 >= 256 && var11 < 512 && !FloorUnderlayDefinition.getKitDefinition(var11 - 256).ready()) {
                  var9 = true;
               }

               if(var11 >= 512 && !class83.getItemDefinition(var11 - 512).readyWorn(this.isFemale)) {
                  var9 = true;
               }
            }

            if(var9) {
               if(this.field2623 != -1L) {
                  var15 = (Model)field2627.get(this.field2623);
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
                     var14 = FloorUnderlayDefinition.getKitDefinition(var13 - 256).getModelData();
                     if(var14 != null) {
                        var16[var11++] = var14;
                     }
                  }

                  if(var13 >= 512) {
                     var14 = class83.getItemDefinition(var13 - 512).getWornModelData(this.isFemale);
                     if(var14 != null) {
                        var16[var11++] = var14;
                     }
                  }
               }

               ModelData var18 = new ModelData(var16, var11);

               for(var13 = 0; var13 < 5; ++var13) {
                  if(this.bodyPartColours[var13] < class203.colorsToReplace[var13].length) {
                     var18.recolor(colorsToFind[var13], class203.colorsToReplace[var13][this.bodyPartColours[var13]]);
                  }

                  if(this.bodyPartColours[var13] < class91.field1414[var13].length) {
                     var18.recolor(field2621[var13], class91.field1414[var13][this.bodyPartColours[var13]]);
                  }
               }

               var15 = var18.light(64, 850, -30, -50, -30);
               field2627.put(var15, var5);
               this.field2623 = var5;
            }
         }

         if(var1 == null && var3 == null) {
            return var15;
         } else {
            Model var17;
            if(var1 != null && var3 != null) {
               var17 = var1.method4620(var15, var2, var3, var4);
            } else if(var1 != null) {
               var17 = var1.method4617(var15, var2);
            } else {
               var17 = var3.method4617(var15, var4);
            }

            return var17;
         }
      }
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(B)LModelData;",
      garbageValue = "35"
   )
   ModelData method3947() {
      if(this.transformedNpcId != -1) {
         return class224.getNpcDefinition(this.transformedNpcId).method4571();
      } else {
         boolean var1 = false;

         int var3;
         for(int var2 = 0; var2 < 12; ++var2) {
            var3 = this.equipmentIds[var2];
            if(var3 >= 256 && var3 < 512 && !FloorUnderlayDefinition.getKitDefinition(var3 - 256).method4335()) {
               var1 = true;
            }

            if(var3 >= 512 && !class83.getItemDefinition(var3 - 512).method4517(this.isFemale)) {
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
                  var6 = FloorUnderlayDefinition.getKitDefinition(var5 - 256).method4317();
                  if(var6 != null) {
                     var7[var3++] = var6;
                  }
               }

               if(var5 >= 512) {
                  var6 = class83.getItemDefinition(var5 - 512).method4518(this.isFemale);
                  if(var6 != null) {
                     var7[var3++] = var6;
                  }
               }
            }

            ModelData var8 = new ModelData(var7, var3);

            for(var5 = 0; var5 < 5; ++var5) {
               if(this.bodyPartColours[var5] < class203.colorsToReplace[var5].length) {
                  var8.recolor(colorsToFind[var5], class203.colorsToReplace[var5][this.bodyPartColours[var5]]);
               }

               if(this.bodyPartColours[var5] < class91.field1414[var5].length) {
                  var8.recolor(field2621[var5], class91.field1414[var5][this.bodyPartColours[var5]]);
               }
            }

            return var8;
         }
      }
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1383977182"
   )
   public int method3941() {
      return this.transformedNpcId == -1?this.equipmentIds[1] + (this.equipmentIds[11] << 5) + (this.bodyPartColours[0] << 25) + (this.bodyPartColours[4] << 20) + (this.equipmentIds[0] << 15) + (this.equipmentIds[8] << 10):305419896 + class224.getNpcDefinition(this.transformedNpcId).id;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "94869707"
   )
   public void method3935(int var1, boolean var2) {
      if(var1 != 1 || !this.isFemale) {
         int var3 = this.equipmentIds[field2624[var1]];
         if(var3 != 0) {
            var3 -= 256;

            KitDefinition var4;
            do {
               if(!var2) {
                  --var3;
                  if(var3 < 0) {
                     var3 = KitDefinition.field3352 - 1;
                  }
               } else {
                  ++var3;
                  if(var3 >= KitDefinition.field3352) {
                     var3 = 0;
                  }
               }

               var4 = FloorUnderlayDefinition.getKitDefinition(var3);
            } while(var4 == null || var4.nonSelectable || var4.bodyPartId != (this.isFemale?7:0) + var1);

            this.equipmentIds[field2624[var1]] = var3 + 256;
            this.setHash();
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(IZI)V",
      garbageValue = "935480133"
   )
   public void method3939(int var1, boolean var2) {
      int var3 = this.bodyPartColours[var1];
      boolean var4;
      if(!var2) {
         do {
            --var3;
            if(var3 < 0) {
               var3 = class203.colorsToReplace[var1].length - 1;
            }

            if(var1 == 4 && var3 >= 8) {
               var4 = false;
            } else {
               var4 = true;
            }
         } while(!var4);
      } else {
         do {
            ++var3;
            if(var3 >= class203.colorsToReplace[var1].length) {
               var3 = 0;
            }

            if(var1 == 4 && var3 >= 8) {
               var4 = false;
            } else {
               var4 = true;
            }
         } while(!var4);
      }

      this.bodyPartColours[var1] = var3;
      this.setHash();
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "6"
   )
   public void method3951(boolean var1) {
      if(this.isFemale != var1) {
         this.method3934((int[])null, this.bodyPartColours, var1, -1);
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(LBuffer;I)V",
      garbageValue = "2144022345"
   )
   public void method3938(Buffer var1) {
      var1.putByte(this.isFemale?1:0);

      int var2;
      for(var2 = 0; var2 < 7; ++var2) {
         int var3 = this.equipmentIds[field2624[var2]];
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

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(II)LObjectComposition;",
      garbageValue = "-2086324149"
   )
   @Export("getObjectDefinition")
   public static ObjectComposition getObjectDefinition(int var0) {
      ObjectComposition var1 = (ObjectComposition)ObjectComposition.objects.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = ObjectComposition.objects_ref.getConfigData(6, var0);
         var1 = new ObjectComposition();
         var1.id = var0;
         if(var2 != null) {
            var1.decode(new Buffer(var2));
         }

         var1.post();
         if(var1.isSolid) {
            var1.interactType = 0;
            var1.field3452 = false;
         }

         ObjectComposition.objects.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-68627908"
   )
   public static boolean method3961() {
      long var0 = class46.currentTimeMs();
      int var2 = (int)(var0 - class238.field3254);
      class238.field3254 = var0;
      if(var2 > 200) {
         var2 = 200;
      }

      class238.field3253 += var2;
      if(class238.field3263 == 0 && class238.field3257 == 0 && class238.field3256 == 0 && class238.field3272 == 0) {
         return true;
      } else if(class238.field3264 == null) {
         return false;
      } else {
         try {
            if(class238.field3253 > 30000) {
               throw new IOException();
            } else {
               FileRequest var3;
               Buffer var4;
               while(class238.field3257 < 20 && class238.field3272 > 0) {
                  var3 = (FileRequest)class238.field3255.method3538();
                  var4 = new Buffer(4);
                  var4.putByte(1);
                  var4.put24bitInt((int)var3.hash);
                  class238.field3264.queueForWrite(var4.payload, 0, 4);
                  class238.field3269.put(var3, var3.hash);
                  --class238.field3272;
                  ++class238.field3257;
               }

               while(class238.field3263 < 20 && class238.field3256 > 0) {
                  var3 = (FileRequest)class238.field3259.peek();
                  var4 = new Buffer(4);
                  var4.putByte(0);
                  var4.put24bitInt((int)var3.hash);
                  class238.field3264.queueForWrite(var4.payload, 0, 4);
                  var3.unlinkDual();
                  class238.field3262.put(var3, var3.hash);
                  --class238.field3256;
                  ++class238.field3263;
               }

               for(int var15 = 0; var15 < 100; ++var15) {
                  int var16 = class238.field3264.available();
                  if(var16 < 0) {
                     throw new IOException();
                  }

                  if(var16 == 0) {
                     break;
                  }

                  class238.field3253 = 0;
                  byte var5 = 0;
                  if(class268.currentRequest == null) {
                     var5 = 8;
                  } else if(class238.field3265 == 0) {
                     var5 = 1;
                  }

                  int var6;
                  int var7;
                  int var8;
                  int var10;
                  if(var5 > 0) {
                     var6 = var5 - class238.field3266.offset;
                     if(var6 > var16) {
                        var6 = var16;
                     }

                     class238.field3264.read(class238.field3266.payload, class238.field3266.offset, var6);
                     if(class238.field3268 != 0) {
                        for(var7 = 0; var7 < var6; ++var7) {
                           class238.field3266.payload[var7 + class238.field3266.offset] ^= class238.field3268;
                        }
                     }

                     class238.field3266.offset += var6;
                     if(class238.field3266.offset < var5) {
                        break;
                     }

                     if(class268.currentRequest == null) {
                        class238.field3266.offset = 0;
                        var7 = class238.field3266.readUnsignedByte();
                        var8 = class238.field3266.readUnsignedShort();
                        int var17 = class238.field3266.readUnsignedByte();
                        var10 = class238.field3266.readInt();
                        long var18 = (long)(var8 + (var7 << 16));
                        FileRequest var13 = (FileRequest)class238.field3269.get(var18);
                        class269.field3679 = true;
                        if(var13 == null) {
                           var13 = (FileRequest)class238.field3262.get(var18);
                           class269.field3679 = false;
                        }

                        if(var13 == null) {
                           throw new IOException();
                        }

                        int var14 = var17 == 0?5:9;
                        class268.currentRequest = var13;
                        class1.field0 = new Buffer(var10 + var14 + class268.currentRequest.padding);
                        class1.field0.putByte(var17);
                        class1.field0.putInt(var10);
                        class238.field3265 = 8;
                        class238.field3266.offset = 0;
                     } else if(class238.field3265 == 0) {
                        if(class238.field3266.payload[0] == -1) {
                           class238.field3265 = 1;
                           class238.field3266.offset = 0;
                        } else {
                           class268.currentRequest = null;
                        }
                     }
                  } else {
                     var6 = class1.field0.payload.length - class268.currentRequest.padding;
                     var7 = 512 - class238.field3265;
                     if(var7 > var6 - class1.field0.offset) {
                        var7 = var6 - class1.field0.offset;
                     }

                     if(var7 > var16) {
                        var7 = var16;
                     }

                     class238.field3264.read(class1.field0.payload, class1.field0.offset, var7);
                     if(class238.field3268 != 0) {
                        for(var8 = 0; var8 < var7; ++var8) {
                           class1.field0.payload[var8 + class1.field0.offset] ^= class238.field3268;
                        }
                     }

                     class1.field0.offset += var7;
                     class238.field3265 += var7;
                     if(var6 == class1.field0.offset) {
                        if(16711935L == class268.currentRequest.hash) {
                           class44.field568 = class1.field0;

                           for(var8 = 0; var8 < 256; ++var8) {
                              IndexData var9 = class238.field3267[var8];
                              if(var9 != null) {
                                 class44.field568.offset = var8 * 8 + 5;
                                 var10 = class44.field568.readInt();
                                 int var11 = class44.field568.readInt();
                                 var9.setInformation(var10, var11);
                              }
                           }
                        } else {
                           class238.field3261.reset();
                           class238.field3261.update(class1.field0.payload, 0, var6);
                           var8 = (int)class238.field3261.getValue();
                           if(var8 != class268.currentRequest.crc) {
                              try {
                                 class238.field3264.close();
                              } catch (Exception var21) {
                                 ;
                              }

                              ++class238.field3258;
                              class238.field3264 = null;
                              class238.field3268 = (byte)((int)(Math.random() * 255.0D + 1.0D));
                              return false;
                           }

                           class238.field3258 = 0;
                           class238.field3252 = 0;
                           class268.currentRequest.index.method4174((int)(class268.currentRequest.hash & 65535L), class1.field0.payload, (class268.currentRequest.hash & 16711680L) == 16711680L, class269.field3679);
                        }

                        class268.currentRequest.unlink();
                        if(class269.field3679) {
                           --class238.field3257;
                        } else {
                           --class238.field3263;
                        }

                        class238.field3265 = 0;
                        class268.currentRequest = null;
                        class1.field0 = null;
                     } else {
                        if(class238.field3265 != 512) {
                           break;
                        }

                        class238.field3265 = 0;
                     }
                  }
               }

               return true;
            }
         } catch (IOException var22) {
            try {
               class238.field3264.close();
            } catch (Exception var20) {
               ;
            }

            ++class238.field3252;
            class238.field3264 = null;
            return false;
         }
      }
   }
}
