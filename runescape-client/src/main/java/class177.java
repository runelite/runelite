import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fu")
public class class177 implements class158 {
   @ObfuscatedName("x")
   static final class177 field2656 = new class177(2, 1, true, true, false);
   @ObfuscatedName("k")
   static final class177 field2658 = new class177(5, 10, false, false, true);
   @ObfuscatedName("q")
   static final class177 field2659 = new class177(3, 2, false, false, true);
   @ObfuscatedName("g")
   static final class177 field2660 = new class177(1, 0, true, true, true);
   @ObfuscatedName("d")
   static final class177 field2661 = new class177(4, 3, false, false, true);
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -74490939
   )
   final int field2662;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1947376511
   )
   public final int field2663;
   @ObfuscatedName("o")
   public final boolean field2664;
   @ObfuscatedName("a")
   public final boolean field2665;
   @ObfuscatedName("rk")
   protected static boolean field2668;
   @ObfuscatedName("p")
   static final class177 field2669 = new class177(0, -1, true, false, true);

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(IIIII)V",
      garbageValue = "-1590018648"
   )
   static final void method3245(int var0, int var1, int var2, int var3) {
      for(int var4 = var1; var4 <= var1 + var3; ++var4) {
         for(int var5 = var0; var5 <= var0 + var2; ++var5) {
            if(var5 >= 0 && var5 < 104 && var4 >= 0 && var4 < 104) {
               class47.field931[0][var5][var4] = 127;
               if(var0 == var5 && var5 > 0) {
                  class10.tileHeights[0][var5][var4] = class10.tileHeights[0][var5 - 1][var4];
               }

               if(var5 == var2 + var0 && var5 < 103) {
                  class10.tileHeights[0][var5][var4] = class10.tileHeights[0][var5 + 1][var4];
               }

               if(var1 == var4 && var4 > 0) {
                  class10.tileHeights[0][var5][var4] = class10.tileHeights[0][var5][var4 - 1];
               }

               if(var4 == var1 + var3 && var4 < 103) {
                  class10.tileHeights[0][var5][var4] = class10.tileHeights[0][var5][1 + var4];
               }
            }
         }
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(S)I",
      garbageValue = "9241"
   )
   public int vmethod4074() {
      return this.field2662;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2134367735"
   )
   static final void method3250() {
      try {
         if(Client.field311 == 0) {
            if(Friend.field152 != null) {
               Friend.field152.method2059();
               Friend.field152 = null;
            }

            class140.field1979 = null;
            Client.field332 = false;
            Client.field303 = 0;
            Client.field311 = 1;
         }

         if(Client.field311 == 1) {
            if(class140.field1979 == null) {
               class140.field1979 = class45.field899.method1949(MessageNode.host, class103.field1676);
            }

            if(class140.field1979.field1667 == 2) {
               throw new IOException();
            }

            if(class140.field1979.field1667 == 1) {
               Friend.field152 = new class110((Socket)class140.field1979.field1664, class45.field899);
               class140.field1979 = null;
               Client.field311 = 2;
            }
         }

         if(Client.field311 == 2) {
            Client.field394.offset = 0;
            Client.field394.method2799(14);
            Friend.field152.method2073(Client.field394.payload, 0, 1);
            Client.field323.offset = 0;
            Client.field311 = 3;
         }

         int var0;
         if(Client.field311 == 3) {
            if(null != class186.field2763) {
               class186.field2763.method1032();
            }

            if(class47.field935 != null) {
               class47.field935.method1032();
            }

            var0 = Friend.field152.method2065();
            if(null != class186.field2763) {
               class186.field2763.method1032();
            }

            if(null != class47.field935) {
               class47.field935.method1032();
            }

            if(var0 != 0) {
               class1.method19(var0);
               return;
            }

            Client.field323.offset = 0;
            Client.field311 = 5;
         }

         int var1;
         int var2;
         if(Client.field311 == 5) {
            int[] var5 = new int[]{(int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D)};
            Client.field394.offset = 0;
            Client.field394.method2799(1);
            Client.field394.method2799(class41.field845.vmethod4074());
            Client.field394.method2802(var5[0]);
            Client.field394.method2802(var5[1]);
            Client.field394.method2802(var5[2]);
            Client.field394.method2802(var5[3]);
            switch(class41.field845.field1632) {
            case 0:
            case 3:
               Client.field394.method2801(class31.field713);
               Client.field394.offset += 5;
               break;
            case 1:
               Client.field394.method2802(((Integer)class107.field1733.field688.get(Integer.valueOf(class186.method3408(class41.username)))).intValue());
               Client.field394.offset += 4;
               break;
            case 2:
               Client.field394.offset += 8;
            }

            Client.field394.method2805(class41.field844);
            Client.field394.method2884(class39.field804, class39.field800);
            Client.field322.offset = 0;
            if(Client.gameState == 40) {
               Client.field322.method2799(18);
            } else {
               Client.field322.method2799(16);
            }

            Client.field322.method2837(0);
            var1 = Client.field322.offset;
            Client.field322.method2802(132);
            Client.field322.method2808(Client.field394.payload, 0, Client.field394.offset);
            var2 = Client.field322.offset;
            Client.field322.method2805(class41.username);
            Client.field322.method2799((Client.isResized?1:0) << 1 | (Client.field283?1:0));
            Client.field322.method2837(class26.field577);
            Client.field322.method2837(class187.field2776);
            class48.method877(Client.field322);
            Client.field322.method2805(class47.field927);
            Client.field322.method2802(class146.field2022);
            Buffer var3 = new Buffer(class11.field108.method4273());
            class11.field108.method4274(var3);
            Client.field322.method2808(var3.payload, 0, var3.payload.length);
            Client.field322.method2799(Client.field285);
            Client.field322.method2802(XItemContainer.field118.field2703);
            Client.field322.method2802(class1.field12.field2703);
            Client.field322.method2802(class7.field65.field2703);
            Client.field322.method2802(class150.field2043.field2703);
            Client.field322.method2802(class150.field2044.field2703);
            Client.field322.method2802(Client.field309.field2703);
            Client.field322.method2802(class227.field3228.field2703);
            Client.field322.method2802(FileOnDisk.field1189.field2703);
            Client.field322.method2802(class184.field2739.field2703);
            Client.field322.method2802(class108.field1738.field2703);
            Client.field322.method2802(class94.field1595.field2703);
            Client.field322.method2802(class49.field962.field2703);
            Client.field322.method2802(class8.field74.field2703);
            Client.field322.method2802(class99.field1649.field2703);
            Client.field322.method2802(class138.field1925.field2703);
            Client.field322.method2802(class157.field2121.field2703);
            Client.field322.method2832(var5, var2, Client.field322.offset);
            Client.field322.method2810(Client.field322.offset - var1);
            Friend.field152.method2073(Client.field322.payload, 0, Client.field322.offset);
            Client.field394.method3038(var5);

            for(int var4 = 0; var4 < 4; ++var4) {
               var5[var4] += 50;
            }

            Client.field323.method3038(var5);
            Client.field311 = 6;
         }

         if(Client.field311 == 6 && Friend.field152.method2054() > 0) {
            var0 = Friend.field152.method2065();
            if(var0 == 21 && Client.gameState == 20) {
               Client.field311 = 7;
            } else if(var0 == 2) {
               Client.field311 = 9;
            } else if(var0 == 15 && Client.gameState == 40) {
               Client.field541 = -1;
               Client.field311 = 13;
            } else if(var0 == 23 && Client.field313 < 1) {
               ++Client.field313;
               Client.field311 = 0;
            } else {
               if(var0 != 29) {
                  class1.method19(var0);
                  return;
               }

               Client.field311 = 11;
            }
         }

         if(Client.field311 == 7 && Friend.field152.method2054() > 0) {
            Client.field314 = (Friend.field152.method2065() + 3) * 60;
            Client.field311 = 8;
         }

         if(Client.field311 == 8) {
            Client.field303 = 0;
            MessageNode.method204("You have only just left another world.", "Your profile will be transferred in:", Client.field314 / 60 + " seconds.");
            if(--Client.field314 <= 0) {
               Client.field311 = 0;
            }

         } else {
            if(Client.field311 == 9 && Friend.field152.method2054() >= 13) {
               boolean var10 = Friend.field152.method2065() == 1;
               Friend.field152.method2055(Client.field323.payload, 0, 4);
               Client.field323.offset = 0;
               boolean var11 = false;
               if(var10) {
                  var1 = Client.field323.method3040() << 24;
                  var1 |= Client.field323.method3040() << 16;
                  var1 |= Client.field323.method3040() << 8;
                  var1 |= Client.field323.method3040();
                  var2 = class186.method3408(class41.username);
                  if(class107.field1733.field688.size() >= 10 && !class107.field1733.field688.containsKey(Integer.valueOf(var2))) {
                     Iterator var12 = class107.field1733.field688.entrySet().iterator();
                     var12.next();
                     var12.remove();
                  }

                  class107.field1733.field688.put(Integer.valueOf(var2), Integer.valueOf(var1));
                  class85.method1694();
               }

               Client.field327 = Friend.field152.method2065();
               Client.field446 = Friend.field152.method2065() == 1;
               Client.localInteractingIndex = Friend.field152.method2065();
               Client.localInteractingIndex <<= 8;
               Client.localInteractingIndex += Friend.field152.method2065();
               Client.field304 = Friend.field152.method2065();
               Friend.field152.method2055(Client.field323.payload, 0, 1);
               Client.field323.offset = 0;
               Client.packetOpcode = Client.field323.method3040();
               Friend.field152.method2055(Client.field323.payload, 0, 2);
               Client.field323.offset = 0;
               Client.field541 = Client.field323.readUnsignedShort();

               try {
                  class100.method1942(class88.field1536, "zap");
               } catch (Throwable var8) {
                  ;
               }

               Client.field311 = 10;
            }

            if(Client.field311 == 10) {
               if(Friend.field152.method2054() >= Client.field541) {
                  Client.field323.offset = 0;
                  Friend.field152.method2055(Client.field323.payload, 0, Client.field541);
                  Player.method248();
                  World.method628(Client.field323);
                  Spotanim.field2802 = -1;
                  class30.xteaChanged(false);
                  Client.packetOpcode = -1;
               }

            } else {
               if(Client.field311 == 11 && Friend.field152.method2054() >= 2) {
                  Client.field323.offset = 0;
                  Friend.field152.method2055(Client.field323.payload, 0, 2);
                  Client.field323.offset = 0;
                  XClanMember.field272 = Client.field323.readUnsignedShort();
                  Client.field311 = 12;
               }

               if(Client.field311 == 12 && Friend.field152.method2054() >= XClanMember.field272) {
                  Client.field323.offset = 0;
                  Friend.field152.method2055(Client.field323.payload, 0, XClanMember.field272);
                  Client.field323.offset = 0;
                  String var13 = Client.field323.method2846();
                  String var7 = Client.field323.method2846();
                  String var6 = Client.field323.method2846();
                  MessageNode.method204(var13, var7, var6);
                  class212.setGameState(10);
               }

               if(Client.field311 == 13) {
                  if(Client.field541 == -1) {
                     if(Friend.field152.method2054() < 2) {
                        return;
                     }

                     Friend.field152.method2055(Client.field323.payload, 0, 2);
                     Client.field323.offset = 0;
                     Client.field541 = Client.field323.readUnsignedShort();
                  }

                  if(Friend.field152.method2054() >= Client.field541) {
                     Friend.field152.method2055(Client.field323.payload, 0, Client.field541);
                     Client.field323.offset = 0;
                     var0 = Client.field541;
                     class9.method119();
                     World.method628(Client.field323);
                     if(var0 != Client.field323.offset) {
                        throw new RuntimeException();
                     }
                  }
               } else {
                  ++Client.field303;
                  if(Client.field303 > 2000) {
                     if(Client.field313 < 1) {
                        if(class103.field1676 == class49.field963) {
                           class103.field1676 = class174.field2637;
                        } else {
                           class103.field1676 = class49.field963;
                        }

                        ++Client.field313;
                        Client.field311 = 0;
                     } else {
                        class1.method19(-3);
                     }
                  }
               }
            }
         }
      } catch (IOException var9) {
         if(Client.field313 < 1) {
            if(class49.field963 == class103.field1676) {
               class103.field1676 = class174.field2637;
            } else {
               class103.field1676 = class49.field963;
            }

            ++Client.field313;
            Client.field311 = 0;
         } else {
            class1.method19(-2);
         }
      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(II)Lclass195;",
      garbageValue = "-404137453"
   )
   public static class195 method3253(int var0) {
      class195 var1 = (class195)class195.field2848.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class195.field2857.getConfigData(8, var0);
         var1 = new class195();
         if(null != var2) {
            var1.method3537(new Buffer(var2));
         }

         class195.field2848.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedSignature(
      signature = "(IIZZZ)V",
      garbageValue = "1"
   )
   class177(int var1, int var2, boolean var3, boolean var4, boolean var5) {
      this.field2662 = var1;
      this.field2663 = var2;
      this.field2664 = var4;
      this.field2665 = var5;
   }
}
