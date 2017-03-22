import java.lang.management.GarbageCollectorMXBean;
import java.math.BigInteger;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ay")
public class class39 {
   @ObfuscatedName("pg")
   static GarbageCollectorMXBean field832;
   @ObfuscatedName("x")
   static final BigInteger field833 = new BigInteger("10001", 16);
   @ObfuscatedName("j")
   static final BigInteger field834 = new BigInteger("8e31d9b794fd40e15cc4550d5db4e2e1990dd5a4247573b111cc8f43aad6eed5960126c8885b4c2786ed6fedcfe675e521a626d833041921375f9ef40517a441c3a0845500be55e2543681e29b63276ed14ce4d6b1a5e76ca2f154cf8f7341253112d0e602f6143e2aabe042f2107459cb8f494a88b1ee4041f5038c54085a73", 16);

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1502807478"
   )
   public static void method814() {
      ItemComposition.field2952.reset();
      ItemComposition.itemModelCache.reset();
      ItemComposition.itemSpriteCache.reset();
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "([BIIII[LCollisionData;I)V",
      garbageValue = "-16703055"
   )
   static final void method815(byte[] var0, int var1, int var2, int var3, int var4, CollisionData[] var5) {
      int var7;
      int var8;
      for(int var6 = 0; var6 < 4; ++var6) {
         for(var7 = 0; var7 < 64; ++var7) {
            for(var8 = 0; var8 < 64; ++var8) {
               if(var7 + var1 > 0 && var1 + var7 < 103 && var2 + var8 > 0 && var8 + var2 < 103) {
                  var5[var6].flags[var1 + var7][var8 + var2] &= -16777217;
               }
            }
         }
      }

      Buffer var10 = new Buffer(var0);

      for(var7 = 0; var7 < 4; ++var7) {
         for(var8 = 0; var8 < 64; ++var8) {
            for(int var9 = 0; var9 < 64; ++var9) {
               class174.method3273(var10, var7, var8 + var1, var2 + var9, var3, var4, 0);
            }
         }
      }

   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-1666451024"
   )
   static int method816(int var0, Script var1, boolean var2) {
      Widget var3 = var2?class26.field624:class32.field754;
      if(var0 == 1700) {
         class32.field756[++class32.field752 - 1] = var3.item;
         return 1;
      } else if(var0 == 1701) {
         if(var3.item != -1) {
            class32.field756[++class32.field752 - 1] = var3.stackSize;
         } else {
            class32.field756[++class32.field752 - 1] = 0;
         }

         return 1;
      } else if(var0 == 1702) {
         class32.field756[++class32.field752 - 1] = var3.index;
         return 1;
      } else {
         return 2;
      }
   }

   @ObfuscatedName("co")
   @ObfuscatedSignature(
      signature = "(LWidget;II)I",
      garbageValue = "514975639"
   )
   static final int method817(Widget var0, int var1) {
      if(var0.dynamicValues != null && var1 < var0.dynamicValues.length) {
         try {
            int[] var2 = var0.dynamicValues[var1];
            int var3 = 0;
            int var4 = 0;
            byte var5 = 0;

            while(true) {
               int var6 = var2[var4++];
               int var7 = 0;
               byte var8 = 0;
               if(var6 == 0) {
                  return var3;
               }

               if(var6 == 1) {
                  var7 = Client.boostedSkillLevels[var2[var4++]];
               }

               if(var6 == 2) {
                  var7 = Client.realSkillLevels[var2[var4++]];
               }

               if(var6 == 3) {
                  var7 = Client.skillExperiences[var2[var4++]];
               }

               int var9;
               Widget var10;
               int var11;
               int var12;
               if(var6 == 4) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = World.method670(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!class154.getItemDefinition(var11).isMembers || Client.isMembers)) {
                     for(var12 = 0; var12 < var10.itemIds.length; ++var12) {
                        if(var11 + 1 == var10.itemIds[var12]) {
                           var7 += var10.itemQuantities[var12];
                        }
                     }
                  }
               }

               if(var6 == 5) {
                  var7 = class165.widgetSettings[var2[var4++]];
               }

               if(var6 == 6) {
                  var7 = class172.field2333[Client.realSkillLevels[var2[var4++]] - 1];
               }

               if(var6 == 7) {
                  var7 = class165.widgetSettings[var2[var4++]] * 100 / '뜛';
               }

               if(var6 == 8) {
                  var7 = class22.localPlayer.combatLevel;
               }

               if(var6 == 9) {
                  for(var9 = 0; var9 < 25; ++var9) {
                     if(class172.field2332[var9]) {
                        var7 += Client.realSkillLevels[var9];
                     }
                  }
               }

               if(var6 == 10) {
                  var9 = var2[var4++] << 16;
                  var9 += var2[var4++];
                  var10 = World.method670(var9);
                  var11 = var2[var4++];
                  if(var11 != -1 && (!class154.getItemDefinition(var11).isMembers || Client.isMembers)) {
                     for(var12 = 0; var12 < var10.itemIds.length; ++var12) {
                        if(var10.itemIds[var12] == 1 + var11) {
                           var7 = 999999999;
                           break;
                        }
                     }
                  }
               }

               if(var6 == 11) {
                  var7 = Client.energy;
               }

               if(var6 == 12) {
                  var7 = Client.weight;
               }

               if(var6 == 13) {
                  var9 = class165.widgetSettings[var2[var4++]];
                  int var13 = var2[var4++];
                  var7 = (var9 & 1 << var13) != 0?1:0;
               }

               if(var6 == 14) {
                  var9 = var2[var4++];
                  var7 = class88.method1937(var9);
               }

               if(var6 == 15) {
                  var8 = 1;
               }

               if(var6 == 16) {
                  var8 = 2;
               }

               if(var6 == 17) {
                  var8 = 3;
               }

               if(var6 == 18) {
                  var7 = CombatInfoListHolder.baseX + (class22.localPlayer.x >> 7);
               }

               if(var6 == 19) {
                  var7 = (class22.localPlayer.y >> 7) + class3.baseY;
               }

               if(var6 == 20) {
                  var7 = var2[var4++];
               }

               if(var8 == 0) {
                  if(var5 == 0) {
                     var3 += var7;
                  }

                  if(var5 == 1) {
                     var3 -= var7;
                  }

                  if(var5 == 2 && var7 != 0) {
                     var3 /= var7;
                  }

                  if(var5 == 3) {
                     var3 *= var7;
                  }

                  var5 = 0;
               } else {
                  var5 = var8;
               }
            }
         } catch (Exception var14) {
            return -1;
         }
      } else {
         return -2;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-641980286"
   )
   static int method818(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 3903) {
         var3 = class32.field756[--class32.field752];
         class32.field756[++class32.field752 - 1] = Client.grandExchangeOffers[var3].method51();
         return 1;
      } else if(var0 == 3904) {
         var3 = class32.field756[--class32.field752];
         class32.field756[++class32.field752 - 1] = Client.grandExchangeOffers[var3].itemId;
         return 1;
      } else if(var0 == 3905) {
         var3 = class32.field756[--class32.field752];
         class32.field756[++class32.field752 - 1] = Client.grandExchangeOffers[var3].price;
         return 1;
      } else if(var0 == 3906) {
         var3 = class32.field756[--class32.field752];
         class32.field756[++class32.field752 - 1] = Client.grandExchangeOffers[var3].totalQuantity;
         return 1;
      } else if(var0 == 3907) {
         var3 = class32.field756[--class32.field752];
         class32.field756[++class32.field752 - 1] = Client.grandExchangeOffers[var3].quantitySold;
         return 1;
      } else if(var0 == 3908) {
         var3 = class32.field756[--class32.field752];
         class32.field756[++class32.field752 - 1] = Client.grandExchangeOffers[var3].spent;
         return 1;
      } else {
         int var12;
         if(var0 == 3910) {
            var3 = class32.field756[--class32.field752];
            var12 = Client.grandExchangeOffers[var3].method66();
            class32.field756[++class32.field752 - 1] = var12 == 0?1:0;
            return 1;
         } else if(var0 == 3911) {
            var3 = class32.field756[--class32.field752];
            var12 = Client.grandExchangeOffers[var3].method66();
            class32.field756[++class32.field752 - 1] = var12 == 2?1:0;
            return 1;
         } else if(var0 == 3912) {
            var3 = class32.field756[--class32.field752];
            var12 = Client.grandExchangeOffers[var3].method66();
            class32.field756[++class32.field752 - 1] = var12 == 5?1:0;
            return 1;
         } else if(var0 == 3913) {
            var3 = class32.field756[--class32.field752];
            var12 = Client.grandExchangeOffers[var3].method66();
            class32.field756[++class32.field752 - 1] = var12 == 1?1:0;
            return 1;
         } else {
            boolean var13;
            if(var0 == 3914) {
               var13 = class32.field756[--class32.field752] == 1;
               if(null != class104.field1702) {
                  class104.field1702.method16(class1.field14, var13);
               }

               return 1;
            } else if(var0 == 3915) {
               var13 = class32.field756[--class32.field752] == 1;
               if(null != class104.field1702) {
                  class104.field1702.method16(class1.field19, var13);
               }

               return 1;
            } else if(var0 == 3916) {
               class32.field752 -= 2;
               var13 = class32.field756[class32.field752] == 1;
               boolean var4 = class32.field756[1 + class32.field752] == 1;
               if(null != class104.field1702) {
                  class104.field1702.method16(new class44(var4), var13);
               }

               return 1;
            } else if(var0 == 3917) {
               var13 = class32.field756[--class32.field752] == 1;
               if(class104.field1702 != null) {
                  class104.field1702.method16(class1.field11, var13);
               }

               return 1;
            } else if(var0 == 3918) {
               var13 = class32.field756[--class32.field752] == 1;
               if(null != class104.field1702) {
                  class104.field1702.method16(class1.field13, var13);
               }

               return 1;
            } else if(var0 == 3919) {
               class32.field756[++class32.field752 - 1] = class104.field1702 == null?0:class104.field1702.field21.size();
               return 1;
            } else {
               class2 var11;
               if(var0 == 3920) {
                  var3 = class32.field756[--class32.field752];
                  var11 = (class2)class104.field1702.field21.get(var3);
                  class32.field756[++class32.field752 - 1] = var11.field26;
                  return 1;
               } else if(var0 == 3921) {
                  var3 = class32.field756[--class32.field752];
                  var11 = (class2)class104.field1702.field21.get(var3);
                  class32.scriptStringStack[++class9.scriptStringStackSize - 1] = var11.method23();
                  return 1;
               } else if(var0 == 3922) {
                  var3 = class32.field756[--class32.field752];
                  var11 = (class2)class104.field1702.field21.get(var3);
                  class32.scriptStringStack[++class9.scriptStringStackSize - 1] = var11.method24();
                  return 1;
               } else if(var0 == 3923) {
                  var3 = class32.field756[--class32.field752];
                  var11 = (class2)class104.field1702.field21.get(var3);
                  long var5 = class99.method2005() - class177.field2662 - var11.field24;
                  int var7 = (int)(var5 / 3600000L);
                  int var8 = (int)((var5 - (long)(var7 * 3600000)) / 60000L);
                  int var9 = (int)((var5 - (long)(3600000 * var7) - (long)(var8 * '\uea60')) / 1000L);
                  String var10 = var7 + ":" + var8 / 10 + var8 % 10 + ":" + var9 / 10 + var9 % 10;
                  class32.scriptStringStack[++class9.scriptStringStackSize - 1] = var10;
                  return 1;
               } else if(var0 == 3924) {
                  var3 = class32.field756[--class32.field752];
                  var11 = (class2)class104.field1702.field21.get(var3);
                  class32.field756[++class32.field752 - 1] = var11.field25.totalQuantity;
                  return 1;
               } else if(var0 == 3925) {
                  var3 = class32.field756[--class32.field752];
                  var11 = (class2)class104.field1702.field21.get(var3);
                  class32.field756[++class32.field752 - 1] = var11.field25.price;
                  return 1;
               } else if(var0 == 3926) {
                  var3 = class32.field756[--class32.field752];
                  var11 = (class2)class104.field1702.field21.get(var3);
                  class32.field756[++class32.field752 - 1] = var11.field25.itemId;
                  return 1;
               } else {
                  return 2;
               }
            }
         }
      }
   }

   class39() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(Lclass159;I)V",
      garbageValue = "1829937943"
   )
   static final void method819(CipherBuffer var0) {
      for(int var1 = 0; var1 < class45.field919; ++var1) {
         int var2 = class45.field932[var1];
         Player var3 = Client.cachedPlayers[var2];
         int var4 = var0.readUnsignedByte();
         if((var4 & 64) != 0) {
            var4 += var0.readUnsignedByte() << 8;
         }

         class148.method2792(var0, var2, var3, var4);
      }

   }

   @ObfuscatedName("ah")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-158100977"
   )
   static final void method820() {
      int var0 = class103.field1685 * 128 + 64;
      int var1 = 64 + class204.field3090 * 128;
      int var2 = class1.method21(var0, var1, class31.plane) - ObjectComposition.field2945;
      if(class65.cameraX < var0) {
         class65.cameraX += class47.field950 + (var0 - class65.cameraX) * class9.field100 / 1000;
         if(class65.cameraX > var0) {
            class65.cameraX = var0;
         }
      }

      if(class65.cameraX > var0) {
         class65.cameraX -= class9.field100 * (class65.cameraX - var0) / 1000 + class47.field950;
         if(class65.cameraX < var0) {
            class65.cameraX = var0;
         }
      }

      if(class8.cameraZ < var2) {
         class8.cameraZ += class9.field100 * (var2 - class8.cameraZ) / 1000 + class47.field950;
         if(class8.cameraZ > var2) {
            class8.cameraZ = var2;
         }
      }

      if(class8.cameraZ > var2) {
         class8.cameraZ -= class9.field100 * (class8.cameraZ - var2) / 1000 + class47.field950;
         if(class8.cameraZ < var2) {
            class8.cameraZ = var2;
         }
      }

      if(CombatInfoListHolder.cameraY < var1) {
         CombatInfoListHolder.cameraY += (var1 - CombatInfoListHolder.cameraY) * class9.field100 / 1000 + class47.field950;
         if(CombatInfoListHolder.cameraY > var1) {
            CombatInfoListHolder.cameraY = var1;
         }
      }

      if(CombatInfoListHolder.cameraY > var1) {
         CombatInfoListHolder.cameraY -= class47.field950 + class9.field100 * (CombatInfoListHolder.cameraY - var1) / 1000;
         if(CombatInfoListHolder.cameraY < var1) {
            CombatInfoListHolder.cameraY = var1;
         }
      }

      var0 = class104.field1701 * 128 + 64;
      var1 = FaceNormal.field1578 * 128 + 64;
      var2 = class1.method21(var0, var1, class31.plane) - Ignore.field240;
      int var3 = var0 - class65.cameraX;
      int var4 = var2 - class8.cameraZ;
      int var5 = var1 - CombatInfoListHolder.cameraY;
      int var6 = (int)Math.sqrt((double)(var3 * var3 + var5 * var5));
      int var7 = (int)(Math.atan2((double)var4, (double)var6) * 325.949D) & 2047;
      int var8 = (int)(Math.atan2((double)var3, (double)var5) * -325.949D) & 2047;
      if(var7 < 128) {
         var7 = 128;
      }

      if(var7 > 383) {
         var7 = 383;
      }

      if(class25.cameraPitch < var7) {
         class25.cameraPitch += (var7 - class25.cameraPitch) * XGrandExchangeOffer.field47 / 1000 + class97.field1646;
         if(class25.cameraPitch > var7) {
            class25.cameraPitch = var7;
         }
      }

      if(class25.cameraPitch > var7) {
         class25.cameraPitch -= class97.field1646 + (class25.cameraPitch - var7) * XGrandExchangeOffer.field47 / 1000;
         if(class25.cameraPitch < var7) {
            class25.cameraPitch = var7;
         }
      }

      int var9 = var8 - class108.cameraYaw;
      if(var9 > 1024) {
         var9 -= 2048;
      }

      if(var9 < -1024) {
         var9 += 2048;
      }

      if(var9 > 0) {
         class108.cameraYaw += var9 * XGrandExchangeOffer.field47 / 1000 + class97.field1646;
         class108.cameraYaw &= 2047;
      }

      if(var9 < 0) {
         class108.cameraYaw -= -var9 * XGrandExchangeOffer.field47 / 1000 + class97.field1646;
         class108.cameraYaw &= 2047;
      }

      int var10 = var8 - class108.cameraYaw;
      if(var10 > 1024) {
         var10 -= 2048;
      }

      if(var10 < -1024) {
         var10 += 2048;
      }

      if(var10 < 0 && var9 > 0 || var10 > 0 && var9 < 0) {
         class108.cameraYaw = var8;
      }

   }
}
