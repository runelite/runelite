import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cb")
@Implements("Preferences")
public class Preferences {
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = -1707369019
   )
   static int field1226;
   @ObfuscatedName("i")
   @Export("hideRoofs")
   boolean hideRoofs;
   @ObfuscatedName("a")
   @Export("muted")
   boolean muted;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -1621038501
   )
   @Export("screenType")
   int screenType;
   @ObfuscatedName("b")
   @Export("rememberedUsername")
   String rememberedUsername;
   @ObfuscatedName("e")
   @Export("hideUsername")
   boolean hideUsername;
   @ObfuscatedName("x")
   @Export("preferences")
   LinkedHashMap preferences;

   static {
      field1226 = 6;
   }

   Preferences() {
      this.screenType = 1;
      this.rememberedUsername = null;
      this.hideUsername = false;
      this.preferences = new LinkedHashMap();
      this.method1711(true);
   }

   @ObfuscatedSignature(
      signature = "(Lgb;)V"
   )
   Preferences(Buffer var1) {
      this.screenType = 1;
      this.rememberedUsername = null;
      this.hideUsername = false;
      this.preferences = new LinkedHashMap();
      if(var1 != null && var1.payload != null) {
         int var2 = var1.readUnsignedByte();
         if(var2 >= 0 && var2 <= field1226) {
            if(var1.readUnsignedByte() == 1) {
               this.hideRoofs = true;
            }

            if(var2 > 1) {
               this.muted = var1.readUnsignedByte() == 1;
            }

            if(var2 > 3) {
               this.screenType = var1.readUnsignedByte();
            }

            if(var2 > 2) {
               int var3 = var1.readUnsignedByte();

               for(int var4 = 0; var4 < var3; ++var4) {
                  int var5 = var1.readInt();
                  int var6 = var1.readInt();
                  this.preferences.put(Integer.valueOf(var5), Integer.valueOf(var6));
               }
            }

            if(var2 > 4) {
               this.rememberedUsername = var1.getNullString();
            }

            if(var2 > 5) {
               this.hideUsername = var1.method3544();
            }
         } else {
            this.method1711(true);
         }
      } else {
         this.method1711(true);
      }

   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1906492067"
   )
   void method1711(boolean var1) {
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)Lgb;",
      garbageValue = "-2035362845"
   )
   @Export("serialize")
   Buffer serialize() {
      Buffer var1 = new Buffer(100);
      var1.putByte(field1226);
      var1.putByte(this.hideRoofs?1:0);
      var1.putByte(this.muted?1:0);
      var1.putByte(this.screenType);
      var1.putByte(this.preferences.size());
      Iterator var2 = this.preferences.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.putInt(((Integer)var3.getKey()).intValue());
         var1.putInt(((Integer)var3.getValue()).intValue());
      }

      var1.putString(this.rememberedUsername != null?this.rememberedUsername:"");
      var1.writeBooleanAsByte(this.hideUsername);
      return var1;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-1342637440"
   )
   public static final void method1719(int var0, int var1) {
      class132.Viewport_mouseX = var0;
      class132.Viewport_mouseY = var1;
      class132.Viewport_containsMouse = true;
      class132.Viewport_entityCountAtMouse = 0;
      class132.Viewport_false0 = false;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Object;ZI)[B",
      garbageValue = "-1759665784"
   )
   @Export("toByteArray")
   public static byte[] toByteArray(Object var0, boolean var1) {
      if(var0 == null) {
         return null;
      } else if(var0 instanceof byte[]) {
         byte[] var6 = (byte[])((byte[])var0);
         if(var1) {
            int var4 = var6.length;
            byte[] var5 = new byte[var4];
            System.arraycopy(var6, 0, var5, 0, var4);
            return var5;
         } else {
            return var6;
         }
      } else if(var0 instanceof AbstractByteBuffer) {
         AbstractByteBuffer var2 = (AbstractByteBuffer)var0;
         return var2.get();
      } else {
         throw new IllegalArgumentException();
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ILcj;ZI)I",
      garbageValue = "230921943"
   )
   static int method1717(int var0, Script var1, boolean var2) {
      if(var0 == 3600) {
         if(WallObject.friendManager.field1228 == 0) {
            class81.intStack[++class5.intStackSize - 1] = -2;
         } else if(WallObject.friendManager.field1228 == 1) {
            class81.intStack[++class5.intStackSize - 1] = -1;
         } else {
            class81.intStack[++class5.intStackSize - 1] = WallObject.friendManager.field1229.getCount();
         }

         return 1;
      } else {
         int var3;
         if(var0 == 3601) {
            var3 = class81.intStack[--class5.intStackSize];
            if(WallObject.friendManager.method1721() && var3 >= 0 && var3 < WallObject.friendManager.field1229.getCount()) {
               Friend var10 = (Friend)WallObject.friendManager.field1229.get(var3);
               class81.scriptStringStack[++class316.scriptStringStackSize - 1] = var10.method5264();
               class81.scriptStringStack[++class316.scriptStringStackSize - 1] = var10.method5247();
            } else {
               class81.scriptStringStack[++class316.scriptStringStackSize - 1] = "";
               class81.scriptStringStack[++class316.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else if(var0 == 3602) {
            var3 = class81.intStack[--class5.intStackSize];
            if(WallObject.friendManager.method1721() && var3 >= 0 && var3 < WallObject.friendManager.field1229.getCount()) {
               class81.intStack[++class5.intStackSize - 1] = ((ChatPlayer)WallObject.friendManager.field1229.get(var3)).world;
            } else {
               class81.intStack[++class5.intStackSize - 1] = 0;
            }

            return 1;
         } else if(var0 == 3603) {
            var3 = class81.intStack[--class5.intStackSize];
            if(WallObject.friendManager.method1721() && var3 >= 0 && var3 < WallObject.friendManager.field1229.getCount()) {
               class81.intStack[++class5.intStackSize - 1] = ((ChatPlayer)WallObject.friendManager.field1229.get(var3)).rank;
            } else {
               class81.intStack[++class5.intStackSize - 1] = 0;
            }

            return 1;
         } else {
            String var6;
            if(var0 == 3604) {
               var6 = class81.scriptStringStack[--class316.scriptStringStackSize];
               int var7 = class81.intStack[--class5.intStackSize];
               PacketNode var5 = class33.method382(ClientPacket.field2400, Client.field1072.field1456);
               var5.packetBuffer.putByte(UnitPriceComparator.getLength(var6) + 1);
               var5.packetBuffer.putString(var6);
               var5.packetBuffer.putShortLE(var7);
               Client.field1072.method2073(var5);
               return 1;
            } else if(var0 == 3605) {
               var6 = class81.scriptStringStack[--class316.scriptStringStackSize];
               WallObject.friendManager.method1782(var6);
               return 1;
            } else if(var0 == 3606) {
               var6 = class81.scriptStringStack[--class316.scriptStringStackSize];
               WallObject.friendManager.method1732(var6);
               return 1;
            } else if(var0 == 3607) {
               var6 = class81.scriptStringStack[--class316.scriptStringStackSize];
               WallObject.friendManager.method1769(var6);
               return 1;
            } else if(var0 == 3608) {
               var6 = class81.scriptStringStack[--class316.scriptStringStackSize];
               WallObject.friendManager.method1733(var6);
               return 1;
            } else if(var0 == 3609) {
               var6 = class81.scriptStringStack[--class316.scriptStringStackSize];
               var6 = ScriptEvent.method1157(var6);
               class81.intStack[++class5.intStackSize - 1] = WallObject.friendManager.isFriended(new Name(var6, KeyFocusListener.loginType), false)?1:0;
               return 1;
            } else if(var0 == 3611) {
               if(KeyFocusListener.clanMemberManager != null) {
                  class81.scriptStringStack[++class316.scriptStringStackSize - 1] = KeyFocusListener.clanMemberManager.field3871;
               } else {
                  class81.scriptStringStack[++class316.scriptStringStackSize - 1] = "";
               }

               return 1;
            } else if(var0 == 3612) {
               if(KeyFocusListener.clanMemberManager != null) {
                  class81.intStack[++class5.intStackSize - 1] = KeyFocusListener.clanMemberManager.getCount();
               } else {
                  class81.intStack[++class5.intStackSize - 1] = 0;
               }

               return 1;
            } else if(var0 == 3613) {
               var3 = class81.intStack[--class5.intStackSize];
               if(KeyFocusListener.clanMemberManager != null && var3 < KeyFocusListener.clanMemberManager.getCount()) {
                  class81.scriptStringStack[++class316.scriptStringStackSize - 1] = KeyFocusListener.clanMemberManager.get(var3).method5246().getName();
               } else {
                  class81.scriptStringStack[++class316.scriptStringStackSize - 1] = "";
               }

               return 1;
            } else if(var0 == 3614) {
               var3 = class81.intStack[--class5.intStackSize];
               if(KeyFocusListener.clanMemberManager != null && var3 < KeyFocusListener.clanMemberManager.getCount()) {
                  class81.intStack[++class5.intStackSize - 1] = ((ChatPlayer)KeyFocusListener.clanMemberManager.get(var3)).method5401();
               } else {
                  class81.intStack[++class5.intStackSize - 1] = 0;
               }

               return 1;
            } else if(var0 == 3615) {
               var3 = class81.intStack[--class5.intStackSize];
               if(KeyFocusListener.clanMemberManager != null && var3 < KeyFocusListener.clanMemberManager.getCount()) {
                  class81.intStack[++class5.intStackSize - 1] = ((ChatPlayer)KeyFocusListener.clanMemberManager.get(var3)).rank;
               } else {
                  class81.intStack[++class5.intStackSize - 1] = 0;
               }

               return 1;
            } else if(var0 == 3616) {
               class81.intStack[++class5.intStackSize - 1] = KeyFocusListener.clanMemberManager != null?KeyFocusListener.clanMemberManager.field3865:0;
               return 1;
            } else if(var0 == 3617) {
               var6 = class81.scriptStringStack[--class316.scriptStringStackSize];
               class66.method1150(var6);
               return 1;
            } else if(var0 == 3618) {
               class81.intStack[++class5.intStackSize - 1] = KeyFocusListener.clanMemberManager != null?KeyFocusListener.clanMemberManager.field3870:0;
               return 1;
            } else if(var0 == 3619) {
               var6 = class81.scriptStringStack[--class316.scriptStringStackSize];
               if(!var6.equals("")) {
                  PacketNode var9 = class33.method382(ClientPacket.field2428, Client.field1072.field1456);
                  var9.packetBuffer.putByte(UnitPriceComparator.getLength(var6));
                  var9.packetBuffer.putString(var6);
                  Client.field1072.method2073(var9);
               }

               return 1;
            } else if(var0 == 3620) {
               Varcs.method2004();
               return 1;
            } else if(var0 == 3621) {
               if(!WallObject.friendManager.method1721()) {
                  class81.intStack[++class5.intStackSize - 1] = -1;
               } else {
                  class81.intStack[++class5.intStackSize - 1] = WallObject.friendManager.field1233.getCount();
               }

               return 1;
            } else if(var0 == 3622) {
               var3 = class81.intStack[--class5.intStackSize];
               if(WallObject.friendManager.method1721() && var3 >= 0 && var3 < WallObject.friendManager.field1233.getCount()) {
                  Ignore var4 = (Ignore)WallObject.friendManager.field1233.get(var3);
                  class81.scriptStringStack[++class316.scriptStringStackSize - 1] = var4.method5264();
                  class81.scriptStringStack[++class316.scriptStringStackSize - 1] = var4.method5247();
               } else {
                  class81.scriptStringStack[++class316.scriptStringStackSize - 1] = "";
                  class81.scriptStringStack[++class316.scriptStringStackSize - 1] = "";
               }

               return 1;
            } else if(var0 == 3623) {
               var6 = class81.scriptStringStack[--class316.scriptStringStackSize];
               var6 = ScriptEvent.method1157(var6);
               class81.intStack[++class5.intStackSize - 1] = WallObject.friendManager.method1727(new Name(var6, KeyFocusListener.loginType))?1:0;
               return 1;
            } else if(var0 == 3624) {
               var3 = class81.intStack[--class5.intStackSize];
               if(KeyFocusListener.clanMemberManager != null && var3 < KeyFocusListener.clanMemberManager.getCount() && KeyFocusListener.clanMemberManager.get(var3).method5246().equals(WorldMapData.localPlayer.name)) {
                  class81.intStack[++class5.intStackSize - 1] = 1;
               } else {
                  class81.intStack[++class5.intStackSize - 1] = 0;
               }

               return 1;
            } else if(var0 == 3625) {
               if(KeyFocusListener.clanMemberManager != null && KeyFocusListener.clanMemberManager.field3868 != null) {
                  class81.scriptStringStack[++class316.scriptStringStackSize - 1] = KeyFocusListener.clanMemberManager.field3868;
               } else {
                  class81.scriptStringStack[++class316.scriptStringStackSize - 1] = "";
               }

               return 1;
            } else if(var0 == 3626) {
               var3 = class81.intStack[--class5.intStackSize];
               if(KeyFocusListener.clanMemberManager != null && var3 < KeyFocusListener.clanMemberManager.getCount() && ((ClanMember)KeyFocusListener.clanMemberManager.get(var3)).method5229()) {
                  class81.intStack[++class5.intStackSize - 1] = 1;
               } else {
                  class81.intStack[++class5.intStackSize - 1] = 0;
               }

               return 1;
            } else if(var0 != 3627) {
               if(var0 == 3628) {
                  WallObject.friendManager.field1229.method5318();
                  return 1;
               } else {
                  boolean var8;
                  if(var0 == 3629) {
                     var8 = class81.intStack[--class5.intStackSize] == 1;
                     WallObject.friendManager.field1229.method5338(new class321(var8));
                     return 1;
                  } else if(var0 == 3630) {
                     var8 = class81.intStack[--class5.intStackSize] == 1;
                     WallObject.friendManager.field1229.method5338(new class322(var8));
                     return 1;
                  } else if(var0 == 3631) {
                     var8 = class81.intStack[--class5.intStackSize] == 1;
                     WallObject.friendManager.field1229.method5338(new class155(var8));
                     return 1;
                  } else if(var0 == 3632) {
                     var8 = class81.intStack[--class5.intStackSize] == 1;
                     WallObject.friendManager.field1229.method5338(new class149(var8));
                     return 1;
                  } else if(var0 == 3633) {
                     var8 = class81.intStack[--class5.intStackSize] == 1;
                     WallObject.friendManager.field1229.method5338(new class154(var8));
                     return 1;
                  } else if(var0 == 3634) {
                     var8 = class81.intStack[--class5.intStackSize] == 1;
                     WallObject.friendManager.field1229.method5338(new class157(var8));
                     return 1;
                  } else if(var0 == 3635) {
                     var8 = class81.intStack[--class5.intStackSize] == 1;
                     WallObject.friendManager.field1229.method5338(new class153(var8));
                     return 1;
                  } else if(var0 == 3636) {
                     var8 = class81.intStack[--class5.intStackSize] == 1;
                     WallObject.friendManager.field1229.method5338(new class151(var8));
                     return 1;
                  } else if(var0 == 3637) {
                     var8 = class81.intStack[--class5.intStackSize] == 1;
                     WallObject.friendManager.field1229.method5338(new class150(var8));
                     return 1;
                  } else if(var0 == 3638) {
                     var8 = class81.intStack[--class5.intStackSize] == 1;
                     WallObject.friendManager.field1229.method5338(new class152(var8));
                     return 1;
                  } else if(var0 == 3639) {
                     WallObject.friendManager.field1229.method5309();
                     return 1;
                  } else if(var0 == 3640) {
                     WallObject.friendManager.field1233.method5318();
                     return 1;
                  } else if(var0 == 3641) {
                     var8 = class81.intStack[--class5.intStackSize] == 1;
                     WallObject.friendManager.field1233.method5338(new class321(var8));
                     return 1;
                  } else if(var0 == 3642) {
                     var8 = class81.intStack[--class5.intStackSize] == 1;
                     WallObject.friendManager.field1233.method5338(new class322(var8));
                     return 1;
                  } else if(var0 == 3643) {
                     WallObject.friendManager.field1233.method5309();
                     return 1;
                  } else if(var0 == 3644) {
                     if(KeyFocusListener.clanMemberManager != null) {
                        KeyFocusListener.clanMemberManager.method5318();
                     }

                     return 1;
                  } else if(var0 == 3645) {
                     var8 = class81.intStack[--class5.intStackSize] == 1;
                     if(KeyFocusListener.clanMemberManager != null) {
                        KeyFocusListener.clanMemberManager.method5338(new class321(var8));
                     }

                     return 1;
                  } else if(var0 == 3646) {
                     var8 = class81.intStack[--class5.intStackSize] == 1;
                     if(KeyFocusListener.clanMemberManager != null) {
                        KeyFocusListener.clanMemberManager.method5338(new class322(var8));
                     }

                     return 1;
                  } else if(var0 == 3647) {
                     var8 = class81.intStack[--class5.intStackSize] == 1;
                     if(KeyFocusListener.clanMemberManager != null) {
                        KeyFocusListener.clanMemberManager.method5338(new class155(var8));
                     }

                     return 1;
                  } else if(var0 == 3648) {
                     var8 = class81.intStack[--class5.intStackSize] == 1;
                     if(KeyFocusListener.clanMemberManager != null) {
                        KeyFocusListener.clanMemberManager.method5338(new class149(var8));
                     }

                     return 1;
                  } else if(var0 == 3649) {
                     var8 = class81.intStack[--class5.intStackSize] == 1;
                     if(KeyFocusListener.clanMemberManager != null) {
                        KeyFocusListener.clanMemberManager.method5338(new class154(var8));
                     }

                     return 1;
                  } else if(var0 == 3650) {
                     var8 = class81.intStack[--class5.intStackSize] == 1;
                     if(KeyFocusListener.clanMemberManager != null) {
                        KeyFocusListener.clanMemberManager.method5338(new class157(var8));
                     }

                     return 1;
                  } else if(var0 == 3651) {
                     var8 = class81.intStack[--class5.intStackSize] == 1;
                     if(KeyFocusListener.clanMemberManager != null) {
                        KeyFocusListener.clanMemberManager.method5338(new class153(var8));
                     }

                     return 1;
                  } else if(var0 == 3652) {
                     var8 = class81.intStack[--class5.intStackSize] == 1;
                     if(KeyFocusListener.clanMemberManager != null) {
                        KeyFocusListener.clanMemberManager.method5338(new class151(var8));
                     }

                     return 1;
                  } else if(var0 == 3653) {
                     var8 = class81.intStack[--class5.intStackSize] == 1;
                     if(KeyFocusListener.clanMemberManager != null) {
                        KeyFocusListener.clanMemberManager.method5338(new class150(var8));
                     }

                     return 1;
                  } else if(var0 == 3654) {
                     var8 = class81.intStack[--class5.intStackSize] == 1;
                     if(KeyFocusListener.clanMemberManager != null) {
                        KeyFocusListener.clanMemberManager.method5338(new class152(var8));
                     }

                     return 1;
                  } else if(var0 == 3655) {
                     if(KeyFocusListener.clanMemberManager != null) {
                        KeyFocusListener.clanMemberManager.method5309();
                     }

                     return 1;
                  } else if(var0 == 3656) {
                     var8 = class81.intStack[--class5.intStackSize] == 1;
                     WallObject.friendManager.field1229.method5338(new class156(var8));
                     return 1;
                  } else if(var0 == 3657) {
                     var8 = class81.intStack[--class5.intStackSize] == 1;
                     if(KeyFocusListener.clanMemberManager != null) {
                        KeyFocusListener.clanMemberManager.method5338(new class156(var8));
                     }

                     return 1;
                  } else {
                     return 2;
                  }
               }
            } else {
               var3 = class81.intStack[--class5.intStackSize];
               if(KeyFocusListener.clanMemberManager != null && var3 < KeyFocusListener.clanMemberManager.getCount() && ((ClanMember)KeyFocusListener.clanMemberManager.get(var3)).method5244()) {
                  class81.intStack[++class5.intStackSize - 1] = 1;
               } else {
                  class81.intStack[++class5.intStackSize - 1] = 0;
               }

               return 1;
            }
         }
      }
   }
}
