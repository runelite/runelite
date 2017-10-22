import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Opcodes;

@ObfuscatedName("ai")
public class class48 implements WorldMapSectionBase {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 1547177185
   )
   int field630;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 487677787
   )
   int field626;
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -174989799
   )
   int field629;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = -1259968469
   )
   int field627;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      intValue = 1041630369
   )
   int field628;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -2060211549
   )
   int field632;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = -1634887405
   )
   int field631;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 510927507
   )
   int field635;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 1210120331
   )
   int field634;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = -929734891
   )
   int field633;

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(III)Z",
      garbageValue = "2005574810"
   )
   public boolean vmethod700(int var1, int var2) {
      return var1 >= (this.field626 << 6) + (this.field629 << 3) && var1 <= (this.field626 << 6) + (this.field629 << 3) + 7 && var2 >= (this.field631 << 6) + (this.field635 << 3) && var2 <= (this.field631 << 6) + (this.field635 << 3) + 7;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(IIII)Z",
      garbageValue = "2147483647"
   )
   public boolean vmethod699(int var1, int var2, int var3) {
      return var1 >= this.field630 && var1 < this.field627 + this.field630?var2 >= (this.field628 << 6) + (this.field632 << 3) && var2 <= (this.field628 << 6) + (this.field632 << 3) + 7 && var3 >= (this.field634 << 6) + (this.field633 << 3) && var3 <= (this.field634 << 6) + (this.field633 << 3) + 7:false;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(Lat;I)V",
      garbageValue = "1123585680"
   )
   public void vmethod720(WorldMapData var1) {
      if(var1.field464 > this.field626) {
         var1.field464 = this.field626;
      }

      if(var1.field468 < this.field626) {
         var1.field468 = this.field626;
      }

      if(var1.field469 > this.field631) {
         var1.field469 = this.field631;
      }

      if(var1.field461 < this.field631) {
         var1.field461 = this.field631;
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)Lhg;",
      garbageValue = "-1413226110"
   )
   public Coordinates vmethod702(int var1, int var2) {
      if(!this.vmethod700(var1, var2)) {
         return null;
      } else {
         int var3 = this.field628 * 64 - this.field626 * 64 + (this.field632 * 8 - this.field629 * 8) + var1;
         int var4 = this.field634 * 64 - this.field631 * 64 + var2 + (this.field633 * 8 - this.field635 * 8);
         return new Coordinates(this.field630, var3, var4);
      }
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(IIII)[I",
      garbageValue = "880778915"
   )
   public int[] vmethod709(int var1, int var2, int var3) {
      if(!this.vmethod699(var1, var2, var3)) {
         return null;
      } else {
         int[] var4 = new int[]{this.field626 * 64 - this.field628 * 64 + var2 + (this.field629 * 8 - this.field632 * 8), var3 + (this.field631 * 64 - this.field634 * 64) + (this.field635 * 8 - this.field633 * 8)};
         return var4;
      }
   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(Lfz;B)V",
      garbageValue = "15"
   )
   public void vmethod703(Buffer var1) {
      this.field630 = var1.readUnsignedByte();
      this.field627 = var1.readUnsignedByte();
      this.field628 = var1.readUnsignedShort();
      this.field632 = var1.readUnsignedByte();
      this.field634 = var1.readUnsignedShort();
      this.field633 = var1.readUnsignedByte();
      this.field626 = var1.readUnsignedShort();
      this.field629 = var1.readUnsignedByte();
      this.field631 = var1.readUnsignedShort();
      this.field635 = var1.readUnsignedByte();
      this.method704();
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-115"
   )
   void method704() {
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)I",
      garbageValue = "-1949905700"
   )
   public static int method707(int var0) {
      --var0;
      var0 |= var0 >>> 1;
      var0 |= var0 >>> 2;
      var0 |= var0 >>> 4;
      var0 |= var0 >>> 8;
      var0 |= var0 >>> 16;
      return var0 + 1;
   }

   @ObfuscatedName("hd")
   @ObfuscatedSignature(
      signature = "(IIIILjava/lang/String;Ljava/lang/String;IIB)V",
      garbageValue = "1"
   )
   @Export("menuAction")
   @Hook("menuActionHook")
   static final void menuAction(int var0, int var1, int var2, int var3, String var4, String var5, int var6, int var7) {
      if(var2 >= 2000) {
         var2 -= 2000;
      }

      if(var2 == 1) {
         Client.field1047 = var6;
         Client.field1022 = var7;
         Client.cursorState = 2;
         Client.field1023 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_ITEM_ON_OBSTACLE);
         if(Client.RUNELITE_PACKET) {
            Client.secretPacketBuffer1.runeliteWriteInt(FileRequest.field3204);
            Client.secretPacketBuffer1.runeliteWriteInt(var0 + class22.baseX * 411265);
         } else {
            Client.secretPacketBuffer1.putShort(FileRequest.field3204);
            Client.secretPacketBuffer1.method3342(var0 + class22.baseX * 411265);
         }

         Client.secretPacketBuffer1.method3225(KeyFocusListener.field659[82]?1:0);
         Client.secretPacketBuffer1.putShortLE(var3 >> 14 & 32767);
         Client.secretPacketBuffer1.method3275(ClanMember.field915);
         Client.secretPacketBuffer1.putShort(class273.baseY + var1);
         Client.secretPacketBuffer1.putShort(class5.selectedItemIndex);
      } else if(var2 == 2) {
         Client.field1047 = var6;
         Client.field1022 = var7;
         Client.cursorState = 2;
         Client.field1023 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_247);
         if(Client.RUNELITE_PACKET) {
            Client.secretPacketBuffer1.runeliteWriteInt(var3 >> 14 & 32767);
            Client.secretPacketBuffer1.runeliteWriteInt(class56.field696);
            Client.secretPacketBuffer1.runeliteWriteInt(Client.field1070);
            Client.secretPacketBuffer1.runeliteWriteInt(class273.baseY + var1);
            Client.secretPacketBuffer1.runeliteWriteInt(var0 + class22.baseX * 411265);
         } else {
            Client.secretPacketBuffer1.method3254(var3 >> 14 & 32767);
            Client.secretPacketBuffer1.method3392(class56.field696);
            Client.secretPacketBuffer1.putShortLE(Client.field1070);
            Client.secretPacketBuffer1.putShortLE(class273.baseY + var1);
            Client.secretPacketBuffer1.method3342(var0 + class22.baseX * 411265);
         }

         Client.secretPacketBuffer1.putByte(KeyFocusListener.field659[82]?1:0);
      } else if(var2 == 3) {
         Client.field1047 = var6;
         Client.field1022 = var7;
         Client.cursorState = 2;
         Client.field1023 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_FIRST_OBSTACLE_ACTION);
         if(Client.RUNELITE_PACKET) {
            Client.secretPacketBuffer1.runeliteWriteInt(var0 + class22.baseX * 411265);
            Client.secretPacketBuffer1.runeliteWriteInt(var3 >> 14 & 32767);
            Client.secretPacketBuffer1.runeliteWriteInt(class273.baseY + var1);
         } else {
            Client.secretPacketBuffer1.putShort(var0 + class22.baseX * 411265);
            Client.secretPacketBuffer1.putShortLE(var3 >> 14 & 32767);
            Client.secretPacketBuffer1.putShort(class273.baseY + var1);
         }

         Client.secretPacketBuffer1.putLEInt(KeyFocusListener.field659[82]?1:0);
      } else if(var2 == 4) {
         Client.field1047 = var6;
         Client.field1022 = var7;
         Client.cursorState = 2;
         Client.field1023 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_SECOND_OBSTACLE_ACTION);
         if(Client.RUNELITE_PACKET) {
            Client.secretPacketBuffer1.runeliteWriteInt(class273.baseY + var1);
            Client.secretPacketBuffer1.runeliteWriteInt(var0 + class22.baseX * 411265);
         } else {
            Client.secretPacketBuffer1.method3254(class273.baseY + var1);
            Client.secretPacketBuffer1.putShort(var0 + class22.baseX * 411265);
         }

         Client.secretPacketBuffer1.putLEInt(KeyFocusListener.field659[82]?1:0);
         Client.secretPacketBuffer1.putShortLE(var3 >> 14 & 32767);
      } else if(var2 == 5) {
         Client.field1047 = var6;
         Client.field1022 = var7;
         Client.cursorState = 2;
         Client.field1023 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_THIRD_OBSTACLE_ACTION);
         if(Client.RUNELITE_PACKET) {
            Client.secretPacketBuffer1.runeliteWriteInt(class273.baseY + var1);
         } else {
            Client.secretPacketBuffer1.method3342(class273.baseY + var1);
         }

         Client.secretPacketBuffer1.method3225(KeyFocusListener.field659[82]?1:0);
         Client.secretPacketBuffer1.putShortLE(var0 + class22.baseX * 411265);
         Client.secretPacketBuffer1.method3254(var3 >> 14 & 32767);
      } else if(var2 == 6) {
         Client.field1047 = var6;
         Client.field1022 = var7;
         Client.cursorState = 2;
         Client.field1023 = 0;
         Client.destinationX = var0;
         Client.destinationY = var1;
         Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_37);
         if(Client.RUNELITE_PACKET) {
            Client.secretPacketBuffer1.runeliteWriteInt(var0 + class22.baseX * 411265);
         } else {
            Client.secretPacketBuffer1.method3342(var0 + class22.baseX * 411265);
         }

         Client.secretPacketBuffer1.putLEInt(KeyFocusListener.field659[82]?1:0);
         Client.secretPacketBuffer1.putShort(var3 >> 14 & 32767);
         Client.secretPacketBuffer1.method3342(class273.baseY + var1);
      } else {
         NPC var8;
         if(var2 == 7) {
            var8 = Client.cachedNPCs[var3];
            if(var8 != null) {
               Client.field1047 = var6;
               Client.field1022 = var7;
               Client.cursorState = 2;
               Client.field1023 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_ITEM_ON_MOB);
               if(Client.RUNELITE_PACKET) {
                  Client.secretPacketBuffer1.runeliteWriteInt(var3);
                  Client.secretPacketBuffer1.runeliteWriteInt(FileRequest.field3204);
                  Client.secretPacketBuffer1.runeliteWriteInt(class5.selectedItemIndex);
               } else {
                  Client.secretPacketBuffer1.putShortLE(var3);
                  Client.secretPacketBuffer1.putShortLE(FileRequest.field3204);
                  Client.secretPacketBuffer1.method3342(class5.selectedItemIndex);
               }

               Client.secretPacketBuffer1.method3225(KeyFocusListener.field659[82]?1:0);
               Client.secretPacketBuffer1.method3275(ClanMember.field915);
            }
         } else if(var2 == 8) {
            var8 = Client.cachedNPCs[var3];
            if(var8 != null) {
               Client.field1047 = var6;
               Client.field1022 = var7;
               Client.cursorState = 2;
               Client.field1023 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_CAST_SPELL_ON_MOB);
               if(Client.RUNELITE_PACKET) {
                  Client.secretPacketBuffer1.runeliteWriteInt(class56.field696);
               } else {
                  Client.secretPacketBuffer1.method3392(class56.field696);
               }

               Client.secretPacketBuffer1.putByte(KeyFocusListener.field659[82]?1:0);
               Client.secretPacketBuffer1.putShortLE(var3);
               Client.secretPacketBuffer1.method3254(Client.field1070);
            }
         } else if(var2 == 9) {
            var8 = Client.cachedNPCs[var3];
            if(var8 != null) {
               Client.field1047 = var6;
               Client.field1022 = var7;
               Client.cursorState = 2;
               Client.field1023 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_FIRST_MOB_ACTION);
               Client.secretPacketBuffer1.putByte(KeyFocusListener.field659[82]?1:0);
               Client.secretPacketBuffer1.putShort(var3);
            }
         } else if(var2 == 10) {
            var8 = Client.cachedNPCs[var3];
            if(var8 != null) {
               Client.field1047 = var6;
               Client.field1022 = var7;
               Client.cursorState = 2;
               Client.field1023 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_ATTACK_NPC);
               Client.secretPacketBuffer1.method3225(KeyFocusListener.field659[82]?1:0);
               Client.secretPacketBuffer1.method3254(var3);
            }
         } else if(var2 == 11) {
            var8 = Client.cachedNPCs[var3];
            if(var8 != null) {
               Client.field1047 = var6;
               Client.field1022 = var7;
               Client.cursorState = 2;
               Client.field1023 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_THIRD_MOB_ACTION);
               if(Client.RUNELITE_PACKET) {
                  Client.secretPacketBuffer1.runeliteWriteInt(var3);
               } else {
                  Client.secretPacketBuffer1.putShort(var3);
               }

               Client.secretPacketBuffer1.method3246(KeyFocusListener.field659[82]?1:0);
            }
         } else if(var2 == 12) {
            var8 = Client.cachedNPCs[var3];
            if(var8 != null) {
               Client.field1047 = var6;
               Client.field1022 = var7;
               Client.cursorState = 2;
               Client.field1023 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_FOURTH_MOB_ACTION);
               if(Client.RUNELITE_PACKET) {
                  Client.secretPacketBuffer1.runeliteWriteInt(var3);
               } else {
                  Client.secretPacketBuffer1.method3254(var3);
               }

               Client.secretPacketBuffer1.putLEInt(KeyFocusListener.field659[82]?1:0);
            }
         } else if(var2 == 13) {
            var8 = Client.cachedNPCs[var3];
            if(var8 != null) {
               Client.field1047 = var6;
               Client.field1022 = var7;
               Client.cursorState = 2;
               Client.field1023 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_FIFTH_MOB_ACTION);
               if(Client.RUNELITE_PACKET) {
                  Client.secretPacketBuffer1.runeliteWriteInt(var3);
               } else {
                  Client.secretPacketBuffer1.putShort(var3);
               }

               Client.secretPacketBuffer1.putLEInt(KeyFocusListener.field659[82]?1:0);
            }
         } else {
            Player var17;
            if(var2 == 14) {
               var17 = Client.cachedPlayers[var3];
               if(var17 != null) {
                  Client.field1047 = var6;
                  Client.field1022 = var7;
                  Client.cursorState = 2;
                  Client.field1023 = 0;
                  Client.destinationX = var0;
                  Client.destinationY = var1;
                  Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_ITEM_ON_PLAYER);
                  if(Client.RUNELITE_PACKET) {
                     Client.secretPacketBuffer1.runeliteWriteInt(ClanMember.field915);
                     Client.secretPacketBuffer1.runeliteWriteInt(FileRequest.field3204);
                     Client.secretPacketBuffer1.runeliteWriteInt(var3);
                     Client.secretPacketBuffer1.runeliteWriteInt(class5.selectedItemIndex);
                  } else {
                     Client.secretPacketBuffer1.method3392(ClanMember.field915);
                     Client.secretPacketBuffer1.method3254(FileRequest.field3204);
                     Client.secretPacketBuffer1.method3342(var3);
                     Client.secretPacketBuffer1.method3254(class5.selectedItemIndex);
                  }

                  Client.secretPacketBuffer1.method3246(KeyFocusListener.field659[82]?1:0);
               }
            } else if(var2 == 15) {
               var17 = Client.cachedPlayers[var3];
               if(var17 != null) {
                  Client.field1047 = var6;
                  Client.field1022 = var7;
                  Client.cursorState = 2;
                  Client.field1023 = 0;
                  Client.destinationX = var0;
                  Client.destinationY = var1;
                  Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_CAST_SPELL_ON_PLAYER);
                  Client.secretPacketBuffer1.putByte(KeyFocusListener.field659[82]?1:0);
                  Client.secretPacketBuffer1.method3275(class56.field696);
                  Client.secretPacketBuffer1.method3342(var3);
                  Client.secretPacketBuffer1.method3254(Client.field1070);
               }
            } else if(var2 == 16) {
               Client.field1047 = var6;
               Client.field1022 = var7;
               Client.cursorState = 2;
               Client.field1023 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_162);
               Client.secretPacketBuffer1.method3246(KeyFocusListener.field659[82]?1:0);
               Client.secretPacketBuffer1.method3254(var0 + class22.baseX * 411265);
               Client.secretPacketBuffer1.putShortLE(class273.baseY + var1);
               Client.secretPacketBuffer1.method3342(FileRequest.field3204);
               Client.secretPacketBuffer1.method3254(class5.selectedItemIndex);
               Client.secretPacketBuffer1.method3342(var3);
               Client.secretPacketBuffer1.putInt(ClanMember.field915);
            } else if(var2 == 17) {
               Client.field1047 = var6;
               Client.field1022 = var7;
               Client.cursorState = 2;
               Client.field1023 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_CAST_SPELL_ON_FLOORITEM);
               if(Client.RUNELITE_PACKET) {
                  Client.secretPacketBuffer1.runeliteWriteInt(var0 + class22.baseX * 411265);
                  Client.secretPacketBuffer1.runeliteWriteInt(class273.baseY + var1);
                  Client.secretPacketBuffer1.runeliteWriteInt(class56.field696);
               } else {
                  Client.secretPacketBuffer1.method3342(var0 + class22.baseX * 411265);
                  Client.secretPacketBuffer1.method3254(class273.baseY + var1);
                  Client.secretPacketBuffer1.method3275(class56.field696);
               }

               Client.secretPacketBuffer1.method3246(KeyFocusListener.field659[82]?1:0);
               Client.secretPacketBuffer1.method3254(var3);
               Client.secretPacketBuffer1.putShortLE(Client.field1070);
            } else if(var2 == 18) {
               Client.field1047 = var6;
               Client.field1022 = var7;
               Client.cursorState = 2;
               Client.field1023 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_102);
               if(Client.RUNELITE_PACKET) {
                  Client.secretPacketBuffer1.runeliteWriteInt(var0 + class22.baseX * 411265);
               } else {
                  Client.secretPacketBuffer1.method3254(var0 + class22.baseX * 411265);
               }

               Client.secretPacketBuffer1.method3225(KeyFocusListener.field659[82]?1:0);
               Client.secretPacketBuffer1.putShortLE(var3);
               Client.secretPacketBuffer1.method3342(class273.baseY + var1);
            } else if(var2 == 19) {
               Client.field1047 = var6;
               Client.field1022 = var7;
               Client.cursorState = 2;
               Client.field1023 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_172);
               if(Client.RUNELITE_PACKET) {
                  Client.secretPacketBuffer1.runeliteWriteInt(var3);
                  Client.secretPacketBuffer1.runeliteWriteInt(var0 + class22.baseX * 411265);
                  Client.secretPacketBuffer1.runeliteWriteInt(class273.baseY + var1);
               } else {
                  Client.secretPacketBuffer1.method3342(var3);
                  Client.secretPacketBuffer1.method3254(var0 + class22.baseX * 411265);
                  Client.secretPacketBuffer1.method3342(class273.baseY + var1);
               }

               Client.secretPacketBuffer1.putLEInt(KeyFocusListener.field659[82]?1:0);
            } else if(var2 == 20) {
               Client.field1047 = var6;
               Client.field1022 = var7;
               Client.cursorState = 2;
               Client.field1023 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_TAKE_ITEM);
               if(Client.RUNELITE_PACKET) {
                  Client.secretPacketBuffer1.runeliteWriteInt(var3);
               } else {
                  Client.secretPacketBuffer1.putShort(var3);
               }

               Client.secretPacketBuffer1.method3246(KeyFocusListener.field659[82]?1:0);
               Client.secretPacketBuffer1.method3254(var0 + class22.baseX * 411265);
               Client.secretPacketBuffer1.putShort(class273.baseY + var1);
            } else if(var2 == 21) {
               Client.field1047 = var6;
               Client.field1022 = var7;
               Client.cursorState = 2;
               Client.field1023 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_180);
               if(Client.RUNELITE_PACKET) {
                  Client.secretPacketBuffer1.runeliteWriteInt(var3);
                  Client.secretPacketBuffer1.runeliteWriteInt(var0 + class22.baseX * 411265);
               } else {
                  Client.secretPacketBuffer1.method3342(var3);
                  Client.secretPacketBuffer1.method3254(var0 + class22.baseX * 411265);
               }

               Client.secretPacketBuffer1.method3246(KeyFocusListener.field659[82]?1:0);
               Client.secretPacketBuffer1.method3342(class273.baseY + var1);
            } else if(var2 == 22) {
               Client.field1047 = var6;
               Client.field1022 = var7;
               Client.cursorState = 2;
               Client.field1023 = 0;
               Client.destinationX = var0;
               Client.destinationY = var1;
               Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_19);
               if(Client.RUNELITE_PACKET) {
                  Client.secretPacketBuffer1.runeliteWriteInt(var3);
                  Client.secretPacketBuffer1.runeliteWriteInt(class273.baseY + var1);
               } else {
                  Client.secretPacketBuffer1.putShort(var3);
                  Client.secretPacketBuffer1.method3254(class273.baseY + var1);
               }

               Client.secretPacketBuffer1.putByte(KeyFocusListener.field659[82]?1:0);
               Client.secretPacketBuffer1.putShortLE(var0 + class22.baseX * 411265);
            } else if(var2 == 23) {
               if(Client.isMenuOpen) {
                  class3.region.method2755();
               } else {
                  class3.region.method2754(class46.plane, var0, var1, true);
               }
            } else {
               Widget var18;
               if(var2 == 24) {
                  var18 = ItemLayer.method2454(var1);
                  boolean var16 = true;
                  if(var18.contentType > 0) {
                     var16 = class18.method140(var18);
                  }

                  if(var16) {
                     Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_SMALL_BUTTON_PRESS);
                     if(Client.RUNELITE_PACKET) {
                        Client.secretPacketBuffer1.runeliteWriteInt(var1);
                     } else {
                        Client.secretPacketBuffer1.putInt(var1);
                     }
                  }
               } else {
                  if(var2 == 25) {
                     var18 = class215.method4064(var1, var0);
                     if(var18 != null) {
                        class54.method777();
                        int var12 = class25.getWidgetConfig(var18);
                        int var11 = var12 >> 11 & 63;
                        class155.method3015(var1, var0, var11, var18.itemId);
                        Client.itemSelectionState = 0;
                        int var15 = class25.getWidgetConfig(var18);
                        int var14 = var15 >> 11 & 63;
                        String var13;
                        if(var14 == 0) {
                           var13 = null;
                        } else if(var18.selectedAction != null && var18.selectedAction.trim().length() != 0) {
                           var13 = var18.selectedAction;
                        } else {
                           var13 = null;
                        }

                        Client.field1072 = var13;
                        if(Client.field1072 == null) {
                           Client.field1072 = "Null";
                        }

                        if(var18.hasScript) {
                           Client.field1087 = var18.name + class24.getColTags(16777215);
                        } else {
                           Client.field1087 = class24.getColTags(65280) + var18.field2683 + class24.getColTags(16777215);
                        }
                     }

                     return;
                  }

                  if(var2 == 26) {
                     CollisionData.method3106();
                  } else {
                     int var19;
                     if(var2 == 28) {
                        Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_SMALL_BUTTON_PRESS);
                        if(Client.RUNELITE_PACKET) {
                           Client.secretPacketBuffer1.runeliteWriteInt(var1);
                        } else {
                           Client.secretPacketBuffer1.putInt(var1);
                        }

                        var18 = ItemLayer.method2454(var1);
                        if(var18.dynamicValues != null && var18.dynamicValues[0][0] == 5) {
                           var19 = var18.dynamicValues[0][1];
                           class211.widgetSettings[var19] = 1 - class211.widgetSettings[var19];
                           class45.method630(var19);
                        }
                     } else if(var2 == 29) {
                        Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_SMALL_BUTTON_PRESS);
                        if(Client.RUNELITE_PACKET) {
                           Client.secretPacketBuffer1.runeliteWriteInt(var1);
                        } else {
                           Client.secretPacketBuffer1.putInt(var1);
                        }

                        var18 = ItemLayer.method2454(var1);
                        if(var18.dynamicValues != null && var18.dynamicValues[0][0] == 5) {
                           var19 = var18.dynamicValues[0][1];
                           if(class211.widgetSettings[var19] != var18.field2756[0]) {
                              class211.widgetSettings[var19] = var18.field2756[0];
                              class45.method630(var19);
                           }
                        }
                     } else if(var2 == 30) {
                        if(Client.field1078 == null) {
                           class51.method761(var1, var0);
                           Client.field1078 = class215.method4064(var1, var0);
                           class45.method647(Client.field1078);
                        }
                     } else if(var2 == 31) {
                        Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_ITEM_ON_ITEM);
                        if(Client.RUNELITE_PACKET) {
                           Client.secretPacketBuffer1.runeliteWriteInt(class5.selectedItemIndex);
                           Client.secretPacketBuffer1.runeliteWriteInt(var0);
                           Client.secretPacketBuffer1.runeliteWriteInt(var1);
                           Client.secretPacketBuffer1.runeliteWriteInt(var3);
                           Client.secretPacketBuffer1.runeliteWriteInt(FileRequest.field3204);
                           Client.secretPacketBuffer1.runeliteWriteInt(ClanMember.field915);
                        } else {
                           Client.secretPacketBuffer1.method3342(class5.selectedItemIndex);
                           Client.secretPacketBuffer1.putShort(var0);
                           Client.secretPacketBuffer1.method3275(var1);
                           Client.secretPacketBuffer1.putShortLE(var3);
                           Client.secretPacketBuffer1.method3342(FileRequest.field3204);
                           Client.secretPacketBuffer1.method3275(ClanMember.field915);
                        }

                        Client.field1025 = 0;
                        class72.field882 = ItemLayer.method2454(var1);
                        Client.field1026 = var0;
                     } else if(var2 == 32) {
                        Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_CAST_SPELL_ON_BAG);
                        if(Client.RUNELITE_PACKET) {
                           Client.secretPacketBuffer1.runeliteWriteInt(var3);
                           Client.secretPacketBuffer1.runeliteWriteInt(Client.field1070);
                           Client.secretPacketBuffer1.runeliteWriteInt(var0);
                           Client.secretPacketBuffer1.runeliteWriteInt(class56.field696);
                           Client.secretPacketBuffer1.runeliteWriteInt(var1);
                        } else {
                           Client.secretPacketBuffer1.putShort(var3);
                           Client.secretPacketBuffer1.putShort(Client.field1070);
                           Client.secretPacketBuffer1.method3342(var0);
                           Client.secretPacketBuffer1.putInt(class56.field696);
                           Client.secretPacketBuffer1.method3392(var1);
                        }

                        Client.field1025 = 0;
                        class72.field882 = ItemLayer.method2454(var1);
                        Client.field1026 = var0;
                     } else if(var2 == 33) {
                        Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_FIRST_ITEM_ACTION);
                        if(Client.RUNELITE_PACKET) {
                           Client.secretPacketBuffer1.runeliteWriteInt(var3);
                           Client.secretPacketBuffer1.runeliteWriteInt(var0);
                           Client.secretPacketBuffer1.runeliteWriteInt(var1);
                        } else {
                           Client.secretPacketBuffer1.method3342(var3);
                           Client.secretPacketBuffer1.putShort(var0);
                           Client.secretPacketBuffer1.method3392(var1);
                        }

                        Client.field1025 = 0;
                        class72.field882 = ItemLayer.method2454(var1);
                        Client.field1026 = var0;
                     } else if(var2 == 34) {
                        Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_EQUIP_BAG_ITEM);
                        if(Client.RUNELITE_PACKET) {
                           Client.secretPacketBuffer1.runeliteWriteInt(var3);
                           Client.secretPacketBuffer1.runeliteWriteInt(var1);
                           Client.secretPacketBuffer1.runeliteWriteInt(var0);
                        } else {
                           Client.secretPacketBuffer1.method3254(var3);
                           Client.secretPacketBuffer1.method3392(var1);
                           Client.secretPacketBuffer1.method3342(var0);
                        }

                        Client.field1025 = 0;
                        class72.field882 = ItemLayer.method2454(var1);
                        Client.field1026 = var0;
                     } else if(var2 == 35) {
                        Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_THIRD_ITEM_ACTION);
                        if(Client.RUNELITE_PACKET) {
                           Client.secretPacketBuffer1.runeliteWriteInt(var0);
                           Client.secretPacketBuffer1.runeliteWriteInt(var1);
                           Client.secretPacketBuffer1.runeliteWriteInt(var3);
                        } else {
                           Client.secretPacketBuffer1.putShortLE(var0);
                           Client.secretPacketBuffer1.method3392(var1);
                           Client.secretPacketBuffer1.method3254(var3);
                        }

                        Client.field1025 = 0;
                        class72.field882 = ItemLayer.method2454(var1);
                        Client.field1026 = var0;
                     } else if(var2 == 36) {
                        Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_FOURTH_ITEM_ACTION);
                        if(Client.RUNELITE_PACKET) {
                           Client.secretPacketBuffer1.runeliteWriteInt(var3);
                           Client.secretPacketBuffer1.runeliteWriteInt(var0);
                           Client.secretPacketBuffer1.runeliteWriteInt(var1);
                        } else {
                           Client.secretPacketBuffer1.method3254(var3);
                           Client.secretPacketBuffer1.method3254(var0);
                           Client.secretPacketBuffer1.method3275(var1);
                        }

                        Client.field1025 = 0;
                        class72.field882 = ItemLayer.method2454(var1);
                        Client.field1026 = var0;
                     } else if(var2 == 37) {
                        Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_DROP_ITEM);
                        if(Client.RUNELITE_PACKET) {
                           Client.secretPacketBuffer1.runeliteWriteInt(var3);
                           Client.secretPacketBuffer1.runeliteWriteInt(var1);
                           Client.secretPacketBuffer1.runeliteWriteInt(var0);
                        } else {
                           Client.secretPacketBuffer1.putShort(var3);
                           Client.secretPacketBuffer1.method3265(var1);
                           Client.secretPacketBuffer1.method3342(var0);
                        }

                        Client.field1025 = 0;
                        class72.field882 = ItemLayer.method2454(var1);
                        Client.field1026 = var0;
                     } else {
                        if(var2 == 38) {
                           class54.method777();
                           var18 = ItemLayer.method2454(var1);
                           Client.itemSelectionState = 1;
                           class5.selectedItemIndex = var0;
                           ClanMember.field915 = var1;
                           FileRequest.field3204 = var3;
                           class45.method647(var18);
                           Client.field1068 = class24.getColTags(16748608) + FaceNormal.getItemDefinition(var3).name + class24.getColTags(16777215);
                           if(Client.field1068 == null) {
                              Client.field1068 = "null";
                           }

                           return;
                        }

                        if(var2 == 39) {
                           Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_239);
                           if(Client.RUNELITE_PACKET) {
                              Client.secretPacketBuffer1.runeliteWriteInt(var0);
                              Client.secretPacketBuffer1.runeliteWriteInt(var3);
                              Client.secretPacketBuffer1.runeliteWriteInt(var1);
                           } else {
                              Client.secretPacketBuffer1.method3254(var0);
                              Client.secretPacketBuffer1.method3254(var3);
                              Client.secretPacketBuffer1.method3392(var1);
                           }

                           Client.field1025 = 0;
                           class72.field882 = ItemLayer.method2454(var1);
                           Client.field1026 = var0;
                        } else if(var2 == 40) {
                           Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_186);
                           if(Client.RUNELITE_PACKET) {
                              Client.secretPacketBuffer1.runeliteWriteInt(var0);
                              Client.secretPacketBuffer1.runeliteWriteInt(var3);
                              Client.secretPacketBuffer1.runeliteWriteInt(var1);
                           } else {
                              Client.secretPacketBuffer1.method3254(var0);
                              Client.secretPacketBuffer1.method3342(var3);
                              Client.secretPacketBuffer1.method3265(var1);
                           }

                           Client.field1025 = 0;
                           class72.field882 = ItemLayer.method2454(var1);
                           Client.field1026 = var0;
                        } else if(var2 == 41) {
                           Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_60);
                           if(Client.RUNELITE_PACKET) {
                              Client.secretPacketBuffer1.runeliteWriteInt(var3);
                              Client.secretPacketBuffer1.runeliteWriteInt(var0);
                              Client.secretPacketBuffer1.runeliteWriteInt(var1);
                           } else {
                              Client.secretPacketBuffer1.method3342(var3);
                              Client.secretPacketBuffer1.putShort(var0);
                              Client.secretPacketBuffer1.method3275(var1);
                           }

                           Client.field1025 = 0;
                           class72.field882 = ItemLayer.method2454(var1);
                           Client.field1026 = var0;
                        } else if(var2 == 42) {
                           Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_73);
                           if(Client.RUNELITE_PACKET) {
                              Client.secretPacketBuffer1.runeliteWriteInt(var1);
                              Client.secretPacketBuffer1.runeliteWriteInt(var3);
                              Client.secretPacketBuffer1.runeliteWriteInt(var0);
                           } else {
                              Client.secretPacketBuffer1.method3275(var1);
                              Client.secretPacketBuffer1.putShort(var3);
                              Client.secretPacketBuffer1.method3342(var0);
                           }

                           Client.field1025 = 0;
                           class72.field882 = ItemLayer.method2454(var1);
                           Client.field1026 = var0;
                        } else if(var2 == 43) {
                           Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_104);
                           if(Client.RUNELITE_PACKET) {
                              Client.secretPacketBuffer1.runeliteWriteInt(var3);
                              Client.secretPacketBuffer1.runeliteWriteInt(var0);
                              Client.secretPacketBuffer1.runeliteWriteInt(var1);
                           } else {
                              Client.secretPacketBuffer1.putShort(var3);
                              Client.secretPacketBuffer1.method3342(var0);
                              Client.secretPacketBuffer1.putInt(var1);
                           }

                           Client.field1025 = 0;
                           class72.field882 = ItemLayer.method2454(var1);
                           Client.field1026 = var0;
                        } else if(var2 == 44) {
                           var17 = Client.cachedPlayers[var3];
                           if(var17 != null) {
                              Client.field1047 = var6;
                              Client.field1022 = var7;
                              Client.cursorState = 2;
                              Client.field1023 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_159);
                              if(Client.RUNELITE_PACKET) {
                                 Client.secretPacketBuffer1.runeliteWriteInt(var3);
                              } else {
                                 Client.secretPacketBuffer1.method3254(var3);
                              }

                              Client.secretPacketBuffer1.method3246(KeyFocusListener.field659[82]?1:0);
                           }
                        } else if(var2 == 45) {
                           var17 = Client.cachedPlayers[var3];
                           if(var17 != null) {
                              Client.field1047 = var6;
                              Client.field1022 = var7;
                              Client.cursorState = 2;
                              Client.field1023 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_77);
                              Client.secretPacketBuffer1.method3225(KeyFocusListener.field659[82]?1:0);
                              Client.secretPacketBuffer1.method3254(var3);
                           }
                        } else if(var2 == 46) {
                           var17 = Client.cachedPlayers[var3];
                           if(var17 != null) {
                              Client.field1047 = var6;
                              Client.field1022 = var7;
                              Client.cursorState = 2;
                              Client.field1023 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_FOLLOW_PLAYER);
                              if(Client.RUNELITE_PACKET) {
                                 Client.secretPacketBuffer1.runeliteWriteInt(var3);
                              } else {
                                 Client.secretPacketBuffer1.method3342(var3);
                              }

                              Client.secretPacketBuffer1.method3246(KeyFocusListener.field659[82]?1:0);
                           }
                        } else if(var2 == 47) {
                           var17 = Client.cachedPlayers[var3];
                           if(var17 != null) {
                              Client.field1047 = var6;
                              Client.field1022 = var7;
                              Client.cursorState = 2;
                              Client.field1023 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_TRADE_PLAYER);
                              if(Client.RUNELITE_PACKET) {
                                 Client.secretPacketBuffer1.runeliteWriteInt(var3);
                              } else {
                                 Client.secretPacketBuffer1.putShort(var3);
                              }

                              Client.secretPacketBuffer1.putLEInt(KeyFocusListener.field659[82]?1:0);
                           }
                        } else if(var2 == 48) {
                           var17 = Client.cachedPlayers[var3];
                           if(var17 != null) {
                              Client.field1047 = var6;
                              Client.field1022 = var7;
                              Client.cursorState = 2;
                              Client.field1023 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_151);
                              if(Client.RUNELITE_PACKET) {
                                 Client.secretPacketBuffer1.runeliteWriteInt(var3);
                              } else {
                                 Client.secretPacketBuffer1.putShort(var3);
                              }

                              Client.secretPacketBuffer1.method3225(KeyFocusListener.field659[82]?1:0);
                           }
                        } else if(var2 == 49) {
                           var17 = Client.cachedPlayers[var3];
                           if(var17 != null) {
                              Client.field1047 = var6;
                              Client.field1022 = var7;
                              Client.cursorState = 2;
                              Client.field1023 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_80);
                              Client.secretPacketBuffer1.putByte(KeyFocusListener.field659[82]?1:0);
                              Client.secretPacketBuffer1.putShortLE(var3);
                           }
                        } else if(var2 == 50) {
                           var17 = Client.cachedPlayers[var3];
                           if(var17 != null) {
                              Client.field1047 = var6;
                              Client.field1022 = var7;
                              Client.cursorState = 2;
                              Client.field1023 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_203);
                              Client.secretPacketBuffer1.putByte(KeyFocusListener.field659[82]?1:0);
                              Client.secretPacketBuffer1.method3254(var3);
                           }
                        } else if(var2 == 51) {
                           var17 = Client.cachedPlayers[var3];
                           if(var17 != null) {
                              Client.field1047 = var6;
                              Client.field1022 = var7;
                              Client.cursorState = 2;
                              Client.field1023 = 0;
                              Client.destinationX = var0;
                              Client.destinationY = var1;
                              Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_REPORT_PLAYER);
                              if(Client.RUNELITE_PACKET) {
                                 Client.secretPacketBuffer1.runeliteWriteInt(var3);
                              } else {
                                 Client.secretPacketBuffer1.putShortLE(var3);
                              }

                              Client.secretPacketBuffer1.method3246(KeyFocusListener.field659[82]?1:0);
                           }
                        } else {
                           label982: {
                              if(var2 != 57) {
                                 if(var2 == 58) {
                                    var18 = class215.method4064(var1, var0);
                                    if(var18 != null) {
                                       Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_125);
                                       if(Client.RUNELITE_PACKET) {
                                          Client.secretPacketBuffer1.runeliteWriteInt(Client.field1169);
                                          Client.secretPacketBuffer1.runeliteWriteInt(class56.field696);
                                          Client.secretPacketBuffer1.runeliteWriteInt(var18.itemId);
                                          Client.secretPacketBuffer1.runeliteWriteInt(var1);
                                          Client.secretPacketBuffer1.runeliteWriteInt(var0);
                                          Client.secretPacketBuffer1.runeliteWriteInt(Client.field1070);
                                       } else {
                                          Client.secretPacketBuffer1.method3254(Client.field1169);
                                          Client.secretPacketBuffer1.method3275(class56.field696);
                                          Client.secretPacketBuffer1.putShortLE(var18.itemId);
                                          Client.secretPacketBuffer1.method3392(var1);
                                          Client.secretPacketBuffer1.method3342(var0);
                                          Client.secretPacketBuffer1.putShortLE(Client.field1070);
                                       }
                                    }
                                    break label982;
                                 }

                                 if(var2 == 1001) {
                                    Client.field1047 = var6;
                                    Client.field1022 = var7;
                                    Client.cursorState = 2;
                                    Client.field1023 = 0;
                                    Client.destinationX = var0;
                                    Client.destinationY = var1;
                                    Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_145);
                                    if(Client.RUNELITE_PACKET) {
                                       Client.secretPacketBuffer1.runeliteWriteInt(var0 + class22.baseX * 411265);
                                    } else {
                                       Client.secretPacketBuffer1.putShort(var0 + class22.baseX * 411265);
                                    }

                                    Client.secretPacketBuffer1.method3246(KeyFocusListener.field659[82]?1:0);
                                    Client.secretPacketBuffer1.putShort(var3 >> 14 & 32767);
                                    Client.secretPacketBuffer1.method3342(class273.baseY + var1);
                                    break label982;
                                 }

                                 if(var2 == 1002) {
                                    Client.field1047 = var6;
                                    Client.field1022 = var7;
                                    Client.cursorState = 2;
                                    Client.field1023 = 0;
                                    Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_EXAMINE_OBSTACLE);
                                    if(Client.RUNELITE_PACKET) {
                                       Client.secretPacketBuffer1.runeliteWriteInt(var3 >> 14 & 32767);
                                    } else {
                                       Client.secretPacketBuffer1.putShort(var3 >> 14 & 32767);
                                    }
                                    break label982;
                                 }

                                 if(var2 == 1003) {
                                    Client.field1047 = var6;
                                    Client.field1022 = var7;
                                    Client.cursorState = 2;
                                    Client.field1023 = 0;
                                    var8 = Client.cachedNPCs[var3];
                                    if(var8 != null) {
                                       NPCComposition var9 = var8.composition;
                                       if(var9.configs != null) {
                                          var9 = var9.transform();
                                       }

                                       if(var9 != null) {
                                          Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_EXAMINE_NPC);
                                          if(Client.RUNELITE_PACKET) {
                                             Client.secretPacketBuffer1.runeliteWriteInt(var9.id);
                                          } else {
                                             Client.secretPacketBuffer1.method3342(var9.id);
                                          }
                                       }
                                    }
                                    break label982;
                                 }

                                 if(var2 == 1004) {
                                    Client.field1047 = var6;
                                    Client.field1022 = var7;
                                    Client.cursorState = 2;
                                    Client.field1023 = 0;
                                    Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_EXAMINE_ITEM);
                                    if(Client.RUNELITE_PACKET) {
                                       Client.secretPacketBuffer1.runeliteWriteInt(var3);
                                    } else {
                                       Client.secretPacketBuffer1.method3342(var3);
                                    }
                                    break label982;
                                 }

                                 if(var2 == 1005) {
                                    var18 = ItemLayer.method2454(var1);
                                    if(var18 != null && var18.itemQuantities[var0] >= 100000) {
                                       class174.sendGameMessage(27, "", var18.itemQuantities[var0] + " x " + FaceNormal.getItemDefinition(var3).name);
                                    } else {
                                       Client.secretPacketBuffer1.putOpcode(Opcodes.PACKET_CLIENT_EXAMINE_ITEM);
                                       if(Client.RUNELITE_PACKET) {
                                          Client.secretPacketBuffer1.runeliteWriteInt(var3);
                                       } else {
                                          Client.secretPacketBuffer1.method3342(var3);
                                       }
                                    }

                                    Client.field1025 = 0;
                                    class72.field882 = ItemLayer.method2454(var1);
                                    Client.field1026 = var0;
                                    break label982;
                                 }

                                 if(var2 != 1007) {
                                    if(var2 == 1010 || var2 == 1011 || var2 == 1009 || var2 == 1008 || var2 == 1012) {
                                       Client.renderOverview.method5346(var2, var3, new Coordinates(var0), new Coordinates(var1));
                                    }
                                    break label982;
                                 }
                              }

                              var18 = class215.method4064(var1, var0);
                              if(var18 != null) {
                                 WorldMapType2.method517(var3, var1, var0, var18.itemId, var5);
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      if(Client.itemSelectionState != 0) {
         Client.itemSelectionState = 0;
         class45.method647(ItemLayer.method2454(ClanMember.field915));
      }

      if(Client.spellSelected) {
         class54.method777();
      }

      if(class72.field882 != null && Client.field1025 == 0) {
         class45.method647(class72.field882);
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1717399863"
   )
   static void method719(boolean var0) {
      class90.loginMessage1 = "";
      class90.loginMessage2 = "Enter your username/email & password.";
      class90.loginMessage3 = "";
      class90.loginIndex = 2;
      if(var0) {
         class90.password = "";
      }

      if(class90.username == null || class90.username.length() <= 0) {
         if(class70.preferences.field1299 != null) {
            class90.username = class70.preferences.field1299;
            class90.field1439 = true;
         } else {
            class90.field1439 = false;
         }
      }

      Ignore.method1103();
   }

   @ObfuscatedName("gd")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-35"
   )
   static final void method718() {
      Client.field1033 = 0;
      int var0 = (class66.localPlayer.x >> 7) + class22.baseX * 411265;
      int var1 = (class66.localPlayer.y >> 7) + class273.baseY;
      if(var0 >= 3053 && var0 <= 3156 && var1 >= 3056 && var1 <= 3136) {
         Client.field1033 = 1;
      }

      if(var0 >= 3072 && var0 <= 3118 && var1 >= 9492 && var1 <= 9535) {
         Client.field1033 = 1;
      }

      if(Client.field1033 == 1 && var0 >= 3139 && var0 <= 3199 && var1 >= 3008 && var1 <= 3062) {
         Client.field1033 = 0;
      }

   }
}
