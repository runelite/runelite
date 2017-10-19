import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Opcodes;

@ObfuscatedName("bt")
@Implements("ItemContainer")
public class ItemContainer extends Node {
   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "Lgs;"
   )
   @Export("itemContainers")
   static HashTable itemContainers;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1108038019
   )
   static int field799;
   @ObfuscatedName("dj")
   @ObfuscatedSignature(
      signature = "Lih;"
   )
   @Export("vorbisIndex")
   static IndexData vorbisIndex;
   @ObfuscatedName("s")
   @Export("itemIds")
   int[] itemIds;
   @ObfuscatedName("q")
   @Export("stackSizes")
   int[] stackSizes;

   static {
      itemContainers = new HashTable(32);
   }

   ItemContainer() {
      this.itemIds = new int[]{-1};
      this.stackSizes = new int[]{0};
   }

   @ObfuscatedName("fb")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-805543986"
   )
   static final void method1077() {
      int var0 = class94.playerIndexesCount;
      int[] var1 = class94.playerIndices;

      for(int var2 = 0; var2 < var0; ++var2) {
         Player var3 = Client.cachedPlayers[var1[var2]];
         if(var3 != null) {
            class36.method479(var3, 1);
         }
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(ILct;ZI)I",
      garbageValue = "142484871"
   )
   static int method1080(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 4200) {
         var3 = class81.intStack[--class278.intStackSize];
         class81.scriptStringStack[++class266.scriptStringStackSize - 1] = FaceNormal.getItemDefinition(var3).name;
         return 1;
      } else {
         int var4;
         ItemComposition var5;
         if(var0 == 4201) {
            class278.intStackSize -= 2;
            var3 = class81.intStack[class278.intStackSize];
            var4 = class81.intStack[class278.intStackSize + 1];
            var5 = FaceNormal.getItemDefinition(var3);
            if(var4 >= 1 && var4 <= 5 && var5.groundActions[var4 - 1] != null) {
               class81.scriptStringStack[++class266.scriptStringStackSize - 1] = var5.groundActions[var4 - 1];
            } else {
               class81.scriptStringStack[++class266.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else if(var0 == 4202) {
            class278.intStackSize -= 2;
            var3 = class81.intStack[class278.intStackSize];
            var4 = class81.intStack[class278.intStackSize + 1];
            var5 = FaceNormal.getItemDefinition(var3);
            if(var4 >= 1 && var4 <= 5 && var5.inventoryActions[var4 - 1] != null) {
               class81.scriptStringStack[++class266.scriptStringStackSize - 1] = var5.inventoryActions[var4 - 1];
            } else {
               class81.scriptStringStack[++class266.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else if(var0 == 4203) {
            var3 = class81.intStack[--class278.intStackSize];
            class81.intStack[++class278.intStackSize - 1] = FaceNormal.getItemDefinition(var3).price;
            return 1;
         } else if(var0 == 4204) {
            var3 = class81.intStack[--class278.intStackSize];
            class81.intStack[++class278.intStackSize - 1] = FaceNormal.getItemDefinition(var3).isStackable == 1?1:0;
            return 1;
         } else {
            ItemComposition var6;
            if(var0 == 4205) {
               var3 = class81.intStack[--class278.intStackSize];
               var6 = FaceNormal.getItemDefinition(var3);
               if(var6.notedTemplate == -1 && var6.note >= 0) {
                  class81.intStack[++class278.intStackSize - 1] = var6.note;
               } else {
                  class81.intStack[++class278.intStackSize - 1] = var3;
               }

               return 1;
            } else if(var0 == 4206) {
               var3 = class81.intStack[--class278.intStackSize];
               var6 = FaceNormal.getItemDefinition(var3);
               if(var6.notedTemplate >= 0 && var6.note >= 0) {
                  class81.intStack[++class278.intStackSize - 1] = var6.note;
               } else {
                  class81.intStack[++class278.intStackSize - 1] = var3;
               }

               return 1;
            } else if(var0 == 4207) {
               var3 = class81.intStack[--class278.intStackSize];
               class81.intStack[++class278.intStackSize - 1] = FaceNormal.getItemDefinition(var3).isMembers?1:0;
               return 1;
            } else if(var0 == 4208) {
               var3 = class81.intStack[--class278.intStackSize];
               var6 = FaceNormal.getItemDefinition(var3);
               if(var6.field3543 == -1 && var6.field3528 >= 0) {
                  class81.intStack[++class278.intStackSize - 1] = var6.field3528;
               } else {
                  class81.intStack[++class278.intStackSize - 1] = var3;
               }

               return 1;
            } else if(var0 == 4209) {
               var3 = class81.intStack[--class278.intStackSize];
               var6 = FaceNormal.getItemDefinition(var3);
               if(var6.field3543 >= 0 && var6.field3528 >= 0) {
                  class81.intStack[++class278.intStackSize - 1] = var6.field3528;
               } else {
                  class81.intStack[++class278.intStackSize - 1] = var3;
               }

               return 1;
            } else if(var0 == 4210) {
               String var7 = class81.scriptStringStack[--class266.scriptStringStackSize];
               var4 = class81.intStack[--class278.intStackSize];
               class227.method4160(var7, var4 == 1);
               class81.intStack[++class278.intStackSize - 1] = class169.field2340;
               return 1;
            } else if(var0 != 4211) {
               if(var0 == 4212) {
                  class14.field300 = 0;
                  return 1;
               } else {
                  return 2;
               }
            } else {
               if(class3.field31 != null && class14.field300 < class169.field2340) {
                  class81.intStack[++class278.intStackSize - 1] = class3.field31[++class14.field300 - 1] & '\uffff';
               } else {
                  class81.intStack[++class278.intStackSize - 1] = -1;
               }

               return 1;
            }
         }
      }
   }

   @ObfuscatedName("ju")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "1463862347"
   )
   static final void method1078(String var0) {
      if(var0 != null) {
         String var1 = WidgetNode.method1087(var0, Permission.field3169);
         if(var1 != null) {
            for(int var2 = 0; var2 < Client.friendCount; ++var2) {
               Friend var3 = Client.friends[var2];
               String var4 = var3.name;
               String var5 = WidgetNode.method1087(var4, Permission.field3169);
               boolean var6;
               if(var0 != null && var4 != null) {
                  if(!var0.startsWith("#") && !var4.startsWith("#")) {
                     var6 = var1.equals(var5);
                  } else {
                     var6 = var0.equals(var4);
                  }
               } else {
                  var6 = false;
               }

               if(var6) {
                  --Client.friendCount;

                  for(int var7 = var2; var7 < Client.friendCount; ++var7) {
                     Client.friends[var7] = Client.friends[var7 + 1];
                  }

                  Client.field1191 = Client.cycleCntr;
                  Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_DELETE_FRIEND);
                  Client.secretPacketBuffer1.putByte(class86.getLength(var0));
                  Client.secretPacketBuffer1.putString(var0);
                  break;
               }
            }

         }
      }
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Lfz;IIIIIII)V",
      garbageValue = "256562957"
   )
   @Export("loadTerrain")
   static final void loadTerrain(Buffer var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7;
      if(var2 >= 0 && var2 < 104 && var3 >= 0 && var3 < 104) {
         class61.tileSettings[var1][var2][var3] = 0;

         while(true) {
            var7 = var0.readUnsignedByte();
            if(var7 == 0) {
               if(var1 == 0) {
                  class61.tileHeights[0][var2][var3] = -class164.method3141(var4 + 932731 + var2, var3 + 556238 + var5) * 8;
               } else {
                  class61.tileHeights[var1][var2][var3] = class61.tileHeights[var1 - 1][var2][var3] - 240;
               }
               break;
            }

            if(var7 == 1) {
               int var8 = var0.readUnsignedByte();
               if(var8 == 1) {
                  var8 = 0;
               }

               if(var1 == 0) {
                  class61.tileHeights[0][var2][var3] = -var8 * 8;
               } else {
                  class61.tileHeights[var1][var2][var3] = class61.tileHeights[var1 - 1][var2][var3] - var8 * 8;
               }
               break;
            }

            if(var7 <= 49) {
               class61.overlayIds[var1][var2][var3] = var0.readByte();
               Huffman.overlayPaths[var1][var2][var3] = (byte)((var7 - 2) / 4);
               class61.overlayRotations[var1][var2][var3] = (byte)(var7 - 2 + var6 & 3);
            } else if(var7 <= 81) {
               class61.tileSettings[var1][var2][var3] = (byte)(var7 - 49);
            } else {
               class2.underlayIds[var1][var2][var3] = (byte)(var7 - 81);
            }
         }
      } else {
         while(true) {
            var7 = var0.readUnsignedByte();
            if(var7 == 0) {
               break;
            }

            if(var7 == 1) {
               var0.readUnsignedByte();
               break;
            }

            if(var7 <= 49) {
               var0.readUnsignedByte();
            }
         }
      }

   }

   @ObfuscatedName("ko")
   @ObfuscatedSignature(
      signature = "([BIB)V",
      garbageValue = "16"
   )
   static void method1069(byte[] var0, int var1) {
      if(Client.field942 == null) {
         Client.field942 = new byte[24];
      }

      class183.method3536(var0, var1, Client.field942, 0, 24);
   }
}
