import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import netscape.javascript.JSObject;

@ObfuscatedName("dk")
public class class129 {
   @ObfuscatedName("l")
   public static int[] field2092;
   @ObfuscatedName("cw")
   public static char field2093;
   @ObfuscatedName("g")
   public static class170 field2096;

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1820193976"
   )
   static final void method2848() {
      try {
         if(Client.field335 == 0) {
            if(ObjectComposition.field993 != null) {
               ObjectComposition.field993.method3029();
               ObjectComposition.field993 = null;
            }

            class174.field2781 = null;
            Client.field356 = false;
            Client.field366 = 0;
            Client.field335 = 1;
         }

         if(Client.field335 == 1) {
            if(class174.field2781 == null) {
               class174.field2781 = class40.field898.method2919(class48.host, class75.field1408);
            }

            if(class174.field2781.field2265 == 2) {
               throw new IOException();
            }

            if(class174.field2781.field2265 == 1) {
               ObjectComposition.field993 = new class146((Socket)class174.field2781.field2270, class40.field898);
               class174.field2781 = null;
               Client.field335 = 2;
            }
         }

         if(Client.field335 == 2) {
            Client.field378.offset = 0;
            Client.field378.method2529(14);
            ObjectComposition.field993.method3028(Client.field378.payload, 0, 1);
            Client.field347.offset = 0;
            Client.field335 = 3;
         }

         int var0;
         if(Client.field335 == 3) {
            if(World.field683 != null) {
               World.field683.method1255();
            }

            if(XClanMember.field652 != null) {
               XClanMember.field652.method1255();
            }

            var0 = ObjectComposition.field993.method3025();
            if(null != World.field683) {
               World.field683.method1255();
            }

            if(XClanMember.field652 != null) {
               XClanMember.field652.method1255();
            }

            if(var0 != 0) {
               class1.method4(var0);
               return;
            }

            Client.field347.offset = 0;
            Client.field335 = 5;
         }

         int var1;
         int var2;
         if(Client.field335 == 5) {
            int[] var7 = new int[]{(int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D), (int)(Math.random() * 9.9999999E7D)};
            Client.field378.offset = 0;
            Client.field378.method2529(1);
            Client.field378.method2529(class33.field765.vmethod3197());
            Client.field378.method2709(var7[0]);
            Client.field378.method2709(var7[1]);
            Client.field378.method2709(var7[2]);
            Client.field378.method2709(var7[3]);
            switch(class33.field765.field2651) {
            case 0:
               Client.field378.offset += 8;
               break;
            case 1:
            case 2:
               Client.field378.method2531(class157.field2336);
               Client.field378.offset += 5;
               break;
            case 3:
               Client.field378.method2709(((Integer)Player.field42.field155.get(Integer.valueOf(class167.method3259(class33.username)))).intValue());
               Client.field378.offset += 4;
            }

            Client.field378.method2535(class33.field764);
            Client.field378.method2565(class4.field83, class4.field77);
            Client.field346.offset = 0;
            if(Client.gameState == 40) {
               Client.field346.method2529(18);
            } else {
               Client.field346.method2529(16);
            }

            Client.field346.method2701(0);
            var1 = Client.field346.offset;
            Client.field346.method2709(126);
            Client.field346.method2581(Client.field378.payload, 0, Client.field378.offset);
            var2 = Client.field346.offset;
            Client.field346.method2535(class33.username);
            Client.field346.method2529((Client.isResized?1:0) << 1 | (Client.field304?1:0));
            Client.field346.method2701(class62.field1267);
            Client.field346.method2701(class77.field1428);
            class125 var3 = Client.field346;
            byte[] var4 = new byte[24];

            int var5;
            try {
               class152.field2283.method4174(0L);
               class152.field2283.method4176(var4);

               for(var5 = 0; var5 < 24 && var4[var5] == 0; ++var5) {
                  ;
               }

               if(var5 >= 24) {
                  throw new IOException();
               }
            } catch (Exception var12) {
               for(int var6 = 0; var6 < 24; ++var6) {
                  var4[var6] = -1;
               }
            }

            var3.method2581(var4, 0, 24);
            Client.field346.method2535(class4.field79);
            Client.field346.method2709(Client.field344);
            Buffer var17 = new Buffer(class162.field2650.method3202());
            class162.field2650.method3201(var17);
            Client.field346.method2581(var17.payload, 0, var17.payload.length);
            Client.field346.method2529(class175.field2785);
            Client.field346.method2709(Client.field331.field2727);
            Client.field346.method2709(class114.field2007.field2727);
            Client.field346.method2709(XItemContainer.field233.field2727);
            Client.field346.method2709(class21.field598.field2727);
            Client.field346.method2709(class109.field1929.field2727);
            Client.field346.method2709(class9.field173.field2727);
            Client.field346.method2709(Client.field476.field2727);
            Client.field346.method2709(VertexNormal.field1688.field2727);
            Client.field346.method2709(ItemComposition.field1199.field2727);
            Client.field346.method2709(Client.field333.field2727);
            Client.field346.method2709(class139.field2139.field2727);
            Client.field346.method2709(class5.field104.field2727);
            Client.field346.method2709(class116.field2015.field2727);
            Client.field346.method2709(class168.field2705.field2727);
            Client.field346.method2709(class140.field2179.field2727);
            Client.field346.method2709(World.field672.field2727);
            Client.field346.method2629(var7, var2, Client.field346.offset);
            Client.field346.method2636(Client.field346.offset - var1);
            ObjectComposition.field993.method3028(Client.field346.payload, 0, Client.field346.offset);
            Client.field378.method2783(var7);

            for(var5 = 0; var5 < 4; ++var5) {
               var7[var5] += 50;
            }

            Client.field347.method2783(var7);
            Client.field335 = 6;
         }

         if(Client.field335 == 6 && ObjectComposition.field993.method3026() > 0) {
            var0 = ObjectComposition.field993.method3025();
            if(var0 == 21 && Client.gameState == 20) {
               Client.field335 = 7;
            } else if(var0 == 2) {
               Client.field335 = 9;
            } else if(var0 == 15 && Client.gameState == 40) {
               Client.field348 = -1;
               Client.field335 = 13;
            } else if(var0 == 23 && Client.field487 < 1) {
               ++Client.field487;
               Client.field335 = 0;
            } else {
               if(var0 != 29) {
                  class1.method4(var0);
                  return;
               }

               Client.field335 = 11;
            }
         }

         if(Client.field335 == 7 && ObjectComposition.field993.method3026() > 0) {
            Client.field338 = (ObjectComposition.field993.method3025() + 3) * 60;
            Client.field335 = 8;
         }

         if(Client.field335 == 8) {
            Client.field366 = 0;
            class5.method88("You have only just left another world.", "Your profile will be transferred in:", Client.field338 / 60 + " seconds.");
            if(--Client.field338 <= 0) {
               Client.field335 = 0;
            }

         } else {
            if(Client.field335 == 9 && ObjectComposition.field993.method3026() >= 13) {
               boolean var14 = ObjectComposition.field993.method3025() == 1;
               ObjectComposition.field993.method3027(Client.field347.payload, 0, 4);
               Client.field347.offset = 0;
               boolean var15 = false;
               if(var14) {
                  var1 = Client.field347.method2788() << 24;
                  var1 |= Client.field347.method2788() << 16;
                  var1 |= Client.field347.method2788() << 8;
                  var1 |= Client.field347.method2788();
                  var2 = class167.method3259(class33.username);
                  if(Player.field42.field155.size() >= 10 && !Player.field42.field155.containsKey(Integer.valueOf(var2))) {
                     Iterator var16 = Player.field42.field155.entrySet().iterator();
                     var16.next();
                     var16.remove();
                  }

                  Player.field42.field155.put(Integer.valueOf(var2), Integer.valueOf(var1));
                  class127.method2819();
               }

               Client.field465 = ObjectComposition.field993.method3025();
               Client.field516 = ObjectComposition.field993.method3025() == 1;
               Client.localInteractingIndex = ObjectComposition.field993.method3025();
               Client.localInteractingIndex <<= 8;
               Client.localInteractingIndex += ObjectComposition.field993.method3025();
               Client.field353 = ObjectComposition.field993.method3025();
               ObjectComposition.field993.method3027(Client.field347.payload, 0, 1);
               Client.field347.offset = 0;
               Client.packetOpcode = Client.field347.method2788();
               ObjectComposition.field993.method3027(Client.field347.payload, 0, 2);
               Client.field347.offset = 0;
               Client.field348 = Client.field347.method2546();

               try {
                  Client var9 = class168.field2706;
                  JSObject.getWindow(var9).call("zap", (Object[])null);
               } catch (Throwable var11) {
                  ;
               }

               Client.field335 = 10;
            }

            if(Client.field335 == 10) {
               if(ObjectComposition.field993.method3026() >= Client.field348) {
                  Client.field347.offset = 0;
                  ObjectComposition.field993.method3027(Client.field347.payload, 0, Client.field348);
                  MessageNode.method769();
                  class4.method52(Client.field347);
                  class125.field2065 = -1;
                  GroundObject.xteaChanged(false);
                  Client.packetOpcode = -1;
               }

            } else {
               if(Client.field335 == 11 && ObjectComposition.field993.method3026() >= 2) {
                  Client.field347.offset = 0;
                  ObjectComposition.field993.method3027(Client.field347.payload, 0, 2);
                  Client.field347.offset = 0;
                  Projectile.field137 = Client.field347.method2546();
                  Client.field335 = 12;
               }

               if(Client.field335 == 12 && ObjectComposition.field993.method3026() >= Projectile.field137) {
                  Client.field347.offset = 0;
                  ObjectComposition.field993.method3027(Client.field347.payload, 0, Projectile.field137);
                  Client.field347.offset = 0;
                  String var18 = Client.field347.method2552();
                  String var10 = Client.field347.method2552();
                  String var19 = Client.field347.method2552();
                  class5.method88(var18, var10, var19);
                  class117.setGameState(10);
               }

               if(Client.field335 == 13) {
                  if(Client.field348 == -1) {
                     if(ObjectComposition.field993.method3026() < 2) {
                        return;
                     }

                     ObjectComposition.field993.method3027(Client.field347.payload, 0, 2);
                     Client.field347.offset = 0;
                     Client.field348 = Client.field347.method2546();
                  }

                  if(ObjectComposition.field993.method3026() >= Client.field348) {
                     ObjectComposition.field993.method3027(Client.field347.payload, 0, Client.field348);
                     Client.field347.offset = 0;
                     var0 = Client.field348;
                     XItemContainer.method177();
                     class4.method52(Client.field347);
                     if(var0 != Client.field347.offset) {
                        throw new RuntimeException();
                     }
                  }
               } else {
                  ++Client.field366;
                  if(Client.field366 > 2000) {
                     if(Client.field487 < 1) {
                        if(class75.field1408 == class51.field1126) {
                           class75.field1408 = ItemLayer.field1731;
                        } else {
                           class75.field1408 = class51.field1126;
                        }

                        ++Client.field487;
                        Client.field335 = 0;
                     } else {
                        class1.method4(-3);
                     }
                  }
               }
            }
         }
      } catch (IOException var13) {
         if(Client.field487 < 1) {
            if(class51.field1126 == class75.field1408) {
               class75.field1408 = ItemLayer.field1731;
            } else {
               class75.field1408 = class51.field1126;
            }

            ++Client.field487;
            Client.field335 = 0;
         } else {
            class1.method4(-2);
         }
      }
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-1984396126"
   )
   public static String method2849(String var0) {
      int var1 = var0.length();
      char[] var2 = new char[var1];
      byte var3 = 2;

      for(int var4 = 0; var4 < var1; ++var4) {
         char var5 = var0.charAt(var4);
         if(var3 == 0) {
            var5 = Character.toLowerCase(var5);
         } else if(var3 == 2 || Character.isUpperCase(var5)) {
            var5 = class155.method3181(var5);
         }

         if(Character.isLetter(var5)) {
            var3 = 0;
         } else if(var5 != 46 && var5 != 63 && var5 != 33) {
            if(Character.isSpaceChar(var5)) {
               if(var3 != 2) {
                  var3 = 1;
               }
            } else {
               var3 = 1;
            }
         } else {
            var3 = 2;
         }

         var2[var4] = var5;
      }

      return new String(var2);
   }
}
