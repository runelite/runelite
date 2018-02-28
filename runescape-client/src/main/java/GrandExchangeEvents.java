import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("v")
@Implements("GrandExchangeEvents")
public class GrandExchangeEvents {
   @ObfuscatedName("qu")
   @ObfuscatedGetter(
      intValue = -663750271
   )
   static int field268;
   @ObfuscatedName("q")
   public static Comparator field260;
   @ObfuscatedName("o")
   public static Comparator field262;
   @ObfuscatedName("p")
   public static Comparator field263;
   @ObfuscatedName("a")
   public static Comparator field261;
   @ObfuscatedName("f")
   @Export("cacheLocations")
   public static String[] cacheLocations;
   @ObfuscatedName("b")
   @Export("events")
   public final List events;

   static {
      field260 = new class19();
      new WorldComparator();
      field262 = new UnitPriceComparator();
      field263 = new class18();
      field261 = new TotalQuantityComparator();
   }

   @ObfuscatedSignature(
      signature = "(Lgn;Z)V",
      garbageValue = "1"
   )
   public GrandExchangeEvents(Buffer var1, boolean var2) {
      int var3 = var1.readUnsignedShort();
      boolean var4 = var1.readUnsignedByte() == 1;
      byte var5;
      if(var4) {
         var5 = 1;
      } else {
         var5 = 0;
      }

      int var6 = var1.readUnsignedShort();
      this.events = new ArrayList(var6);

      for(int var7 = 0; var7 < var6; ++var7) {
         this.events.add(new GrandExchangeEvent(var1, var5, var3));
      }

   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(Ljava/util/Comparator;ZI)V",
      garbageValue = "2068524567"
   )
   @Export("sort")
   public void sort(Comparator var1, boolean var2) {
      if(var2) {
         Collections.sort(this.events, var1);
      } else {
         Collections.sort(this.events, Collections.reverseOrder(var1));
      }

   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(ILca;ZI)I",
      garbageValue = "1609929319"
   )
   static int method75(int var0, Script var1, boolean var2) {
      Widget var3;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = NetWriter.getWidget(class80.intStack[--class80.intStackSize]);
      } else {
         var3 = var2?class223.field2643:class80.field1228;
      }

      if(var0 == 1927) {
         if(class80.field1231 >= 10) {
            throw new RuntimeException();
         } else if(var3.field2886 == null) {
            return 0;
         } else {
            ScriptEvent var4 = new ScriptEvent();
            var4.widget = var3;
            var4.objs = var3.field2886;
            var4.field751 = class80.field1231 + 1;
            Client.field821.addFront(var4);
            return 1;
         }
      } else {
         return 2;
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(ILca;ZI)I",
      garbageValue = "64687252"
   )
   static int method72(int var0, Script var1, boolean var2) {
      if(var0 == 3600) {
         if(ContextMenuRow.friendManager.field1195 == 0) {
            class80.intStack[++class80.intStackSize - 1] = -2;
         } else if(ContextMenuRow.friendManager.field1195 == 1) {
            class80.intStack[++class80.intStackSize - 1] = -1;
         } else {
            class80.intStack[++class80.intStackSize - 1] = ContextMenuRow.friendManager.field1194.getCount();
         }

         return 1;
      } else {
         int var3;
         if(var0 == 3601) {
            var3 = class80.intStack[--class80.intStackSize];
            if(ContextMenuRow.friendManager.method1695() && var3 >= 0 && var3 < ContextMenuRow.friendManager.field1194.getCount()) {
               Friend var9 = (Friend)ContextMenuRow.friendManager.field1194.get(var3);
               class80.scriptStringStack[++class43.scriptStringStackSize - 1] = var9.method5184();
               class80.scriptStringStack[++class43.scriptStringStackSize - 1] = var9.method5182();
            } else {
               class80.scriptStringStack[++class43.scriptStringStackSize - 1] = "";
               class80.scriptStringStack[++class43.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else if(var0 == 3602) {
            var3 = class80.intStack[--class80.intStackSize];
            if(ContextMenuRow.friendManager.method1695() && var3 >= 0 && var3 < ContextMenuRow.friendManager.field1194.getCount()) {
               class80.intStack[++class80.intStackSize - 1] = ((ChatPlayer)ContextMenuRow.friendManager.field1194.get(var3)).world;
            } else {
               class80.intStack[++class80.intStackSize - 1] = 0;
            }

            return 1;
         } else if(var0 == 3603) {
            var3 = class80.intStack[--class80.intStackSize];
            if(ContextMenuRow.friendManager.method1695() && var3 >= 0 && var3 < ContextMenuRow.friendManager.field1194.getCount()) {
               class80.intStack[++class80.intStackSize - 1] = ((ChatPlayer)ContextMenuRow.friendManager.field1194.get(var3)).rank;
            } else {
               class80.intStack[++class80.intStackSize - 1] = 0;
            }

            return 1;
         } else {
            String var5;
            if(var0 == 3604) {
               var5 = class80.scriptStringStack[--class43.scriptStringStackSize];
               int var6 = class80.intStack[--class80.intStackSize];
               SoundTaskDataProvider.method799(var5, var6);
               return 1;
            } else if(var0 == 3605) {
               var5 = class80.scriptStringStack[--class43.scriptStringStackSize];
               ContextMenuRow.friendManager.method1730(var5);
               return 1;
            } else if(var0 == 3606) {
               var5 = class80.scriptStringStack[--class43.scriptStringStackSize];
               ContextMenuRow.friendManager.method1706(var5);
               return 1;
            } else if(var0 == 3607) {
               var5 = class80.scriptStringStack[--class43.scriptStringStackSize];
               ContextMenuRow.friendManager.method1698(var5);
               return 1;
            } else if(var0 == 3608) {
               var5 = class80.scriptStringStack[--class43.scriptStringStackSize];
               ContextMenuRow.friendManager.method1722(var5);
               return 1;
            } else if(var0 == 3609) {
               var5 = class80.scriptStringStack[--class43.scriptStringStackSize];
               var5 = class84.method1848(var5);
               class80.intStack[++class80.intStackSize - 1] = ContextMenuRow.friendManager.isFriended(new Name(var5, class234.loginType), false)?1:0;
               return 1;
            } else if(var0 == 3611) {
               if(class2.clanMemberManager != null) {
                  class80.scriptStringStack[++class43.scriptStringStackSize - 1] = class2.clanMemberManager.field3745;
               } else {
                  class80.scriptStringStack[++class43.scriptStringStackSize - 1] = "";
               }

               return 1;
            } else if(var0 == 3612) {
               if(class2.clanMemberManager != null) {
                  class80.intStack[++class80.intStackSize - 1] = class2.clanMemberManager.getCount();
               } else {
                  class80.intStack[++class80.intStackSize - 1] = 0;
               }

               return 1;
            } else if(var0 == 3613) {
               var3 = class80.intStack[--class80.intStackSize];
               if(class2.clanMemberManager != null && var3 < class2.clanMemberManager.getCount()) {
                  class80.scriptStringStack[++class43.scriptStringStackSize - 1] = class2.clanMemberManager.get(var3).method5183().getName();
               } else {
                  class80.scriptStringStack[++class43.scriptStringStackSize - 1] = "";
               }

               return 1;
            } else if(var0 == 3614) {
               var3 = class80.intStack[--class80.intStackSize];
               if(class2.clanMemberManager != null && var3 < class2.clanMemberManager.getCount()) {
                  class80.intStack[++class80.intStackSize - 1] = ((ChatPlayer)class2.clanMemberManager.get(var3)).method5336();
               } else {
                  class80.intStack[++class80.intStackSize - 1] = 0;
               }

               return 1;
            } else if(var0 == 3615) {
               var3 = class80.intStack[--class80.intStackSize];
               if(class2.clanMemberManager != null && var3 < class2.clanMemberManager.getCount()) {
                  class80.intStack[++class80.intStackSize - 1] = ((ChatPlayer)class2.clanMemberManager.get(var3)).rank;
               } else {
                  class80.intStack[++class80.intStackSize - 1] = 0;
               }

               return 1;
            } else if(var0 == 3616) {
               class80.intStack[++class80.intStackSize - 1] = class2.clanMemberManager != null?class2.clanMemberManager.field3739:0;
               return 1;
            } else if(var0 == 3617) {
               var5 = class80.scriptStringStack[--class43.scriptStringStackSize];
               MapIcon.method547(var5);
               return 1;
            } else if(var0 == 3618) {
               class80.intStack[++class80.intStackSize - 1] = class2.clanMemberManager != null?class2.clanMemberManager.field3744:0;
               return 1;
            } else if(var0 == 3619) {
               var5 = class80.scriptStringStack[--class43.scriptStringStackSize];
               if(!var5.equals("")) {
                  PacketNode var8 = class61.method1076(ClientPacket.field2410, Client.field863.field1434);
                  var8.packetBuffer.putByte(class43.getLength(var5));
                  var8.packetBuffer.putString(var5);
                  Client.field863.method2039(var8);
               }

               return 1;
            } else if(var0 == 3620) {
               PacketNode var10 = class61.method1076(ClientPacket.field2410, Client.field863.field1434);
               var10.packetBuffer.putByte(0);
               Client.field863.method2039(var10);
               return 1;
            } else if(var0 == 3621) {
               if(!ContextMenuRow.friendManager.method1695()) {
                  class80.intStack[++class80.intStackSize - 1] = -1;
               } else {
                  class80.intStack[++class80.intStackSize - 1] = ContextMenuRow.friendManager.field1193.getCount();
               }

               return 1;
            } else if(var0 == 3622) {
               var3 = class80.intStack[--class80.intStackSize];
               if(ContextMenuRow.friendManager.method1695() && var3 >= 0 && var3 < ContextMenuRow.friendManager.field1193.getCount()) {
                  Ignore var4 = (Ignore)ContextMenuRow.friendManager.field1193.get(var3);
                  class80.scriptStringStack[++class43.scriptStringStackSize - 1] = var4.method5184();
                  class80.scriptStringStack[++class43.scriptStringStackSize - 1] = var4.method5182();
               } else {
                  class80.scriptStringStack[++class43.scriptStringStackSize - 1] = "";
                  class80.scriptStringStack[++class43.scriptStringStackSize - 1] = "";
               }

               return 1;
            } else if(var0 == 3623) {
               var5 = class80.scriptStringStack[--class43.scriptStringStackSize];
               var5 = class84.method1848(var5);
               class80.intStack[++class80.intStackSize - 1] = ContextMenuRow.friendManager.method1701(new Name(var5, class234.loginType))?1:0;
               return 1;
            } else if(var0 == 3624) {
               var3 = class80.intStack[--class80.intStackSize];
               if(class2.clanMemberManager != null && var3 < class2.clanMemberManager.getCount() && class2.clanMemberManager.get(var3).method5183().equals(OwnWorldComparator.localPlayer.name)) {
                  class80.intStack[++class80.intStackSize - 1] = 1;
               } else {
                  class80.intStack[++class80.intStackSize - 1] = 0;
               }

               return 1;
            } else if(var0 == 3625) {
               if(class2.clanMemberManager != null && class2.clanMemberManager.field3742 != null) {
                  class80.scriptStringStack[++class43.scriptStringStackSize - 1] = class2.clanMemberManager.field3742;
               } else {
                  class80.scriptStringStack[++class43.scriptStringStackSize - 1] = "";
               }

               return 1;
            } else if(var0 == 3626) {
               var3 = class80.intStack[--class80.intStackSize];
               if(class2.clanMemberManager != null && var3 < class2.clanMemberManager.getCount() && ((ClanMember)class2.clanMemberManager.get(var3)).method5167()) {
                  class80.intStack[++class80.intStackSize - 1] = 1;
               } else {
                  class80.intStack[++class80.intStackSize - 1] = 0;
               }

               return 1;
            } else if(var0 != 3627) {
               if(var0 == 3628) {
                  ContextMenuRow.friendManager.field1194.method5305();
                  return 1;
               } else {
                  boolean var7;
                  if(var0 == 3629) {
                     var7 = class80.intStack[--class80.intStackSize] == 1;
                     ContextMenuRow.friendManager.field1194.method5252(new class313(var7));
                     return 1;
                  } else if(var0 == 3630) {
                     var7 = class80.intStack[--class80.intStackSize] == 1;
                     ContextMenuRow.friendManager.field1194.method5252(new class314(var7));
                     return 1;
                  } else if(var0 == 3631) {
                     var7 = class80.intStack[--class80.intStackSize] == 1;
                     ContextMenuRow.friendManager.field1194.method5252(new class154(var7));
                     return 1;
                  } else if(var0 == 3632) {
                     var7 = class80.intStack[--class80.intStackSize] == 1;
                     ContextMenuRow.friendManager.field1194.method5252(new class148(var7));
                     return 1;
                  } else if(var0 == 3633) {
                     var7 = class80.intStack[--class80.intStackSize] == 1;
                     ContextMenuRow.friendManager.field1194.method5252(new class153(var7));
                     return 1;
                  } else if(var0 == 3634) {
                     var7 = class80.intStack[--class80.intStackSize] == 1;
                     ContextMenuRow.friendManager.field1194.method5252(new class156(var7));
                     return 1;
                  } else if(var0 == 3635) {
                     var7 = class80.intStack[--class80.intStackSize] == 1;
                     ContextMenuRow.friendManager.field1194.method5252(new class152(var7));
                     return 1;
                  } else if(var0 == 3636) {
                     var7 = class80.intStack[--class80.intStackSize] == 1;
                     ContextMenuRow.friendManager.field1194.method5252(new class150(var7));
                     return 1;
                  } else if(var0 == 3637) {
                     var7 = class80.intStack[--class80.intStackSize] == 1;
                     ContextMenuRow.friendManager.field1194.method5252(new class149(var7));
                     return 1;
                  } else if(var0 == 3638) {
                     var7 = class80.intStack[--class80.intStackSize] == 1;
                     ContextMenuRow.friendManager.field1194.method5252(new class151(var7));
                     return 1;
                  } else if(var0 == 3639) {
                     ContextMenuRow.friendManager.field1194.method5242();
                     return 1;
                  } else if(var0 == 3640) {
                     ContextMenuRow.friendManager.field1193.method5305();
                     return 1;
                  } else if(var0 == 3641) {
                     var7 = class80.intStack[--class80.intStackSize] == 1;
                     ContextMenuRow.friendManager.field1193.method5252(new class313(var7));
                     return 1;
                  } else if(var0 == 3642) {
                     var7 = class80.intStack[--class80.intStackSize] == 1;
                     ContextMenuRow.friendManager.field1193.method5252(new class314(var7));
                     return 1;
                  } else if(var0 == 3643) {
                     ContextMenuRow.friendManager.field1193.method5242();
                     return 1;
                  } else if(var0 == 3644) {
                     if(class2.clanMemberManager != null) {
                        class2.clanMemberManager.method5305();
                     }

                     return 1;
                  } else if(var0 == 3645) {
                     var7 = class80.intStack[--class80.intStackSize] == 1;
                     if(class2.clanMemberManager != null) {
                        class2.clanMemberManager.method5252(new class313(var7));
                     }

                     return 1;
                  } else if(var0 == 3646) {
                     var7 = class80.intStack[--class80.intStackSize] == 1;
                     if(class2.clanMemberManager != null) {
                        class2.clanMemberManager.method5252(new class314(var7));
                     }

                     return 1;
                  } else if(var0 == 3647) {
                     var7 = class80.intStack[--class80.intStackSize] == 1;
                     if(class2.clanMemberManager != null) {
                        class2.clanMemberManager.method5252(new class154(var7));
                     }

                     return 1;
                  } else if(var0 == 3648) {
                     var7 = class80.intStack[--class80.intStackSize] == 1;
                     if(class2.clanMemberManager != null) {
                        class2.clanMemberManager.method5252(new class148(var7));
                     }

                     return 1;
                  } else if(var0 == 3649) {
                     var7 = class80.intStack[--class80.intStackSize] == 1;
                     if(class2.clanMemberManager != null) {
                        class2.clanMemberManager.method5252(new class153(var7));
                     }

                     return 1;
                  } else if(var0 == 3650) {
                     var7 = class80.intStack[--class80.intStackSize] == 1;
                     if(class2.clanMemberManager != null) {
                        class2.clanMemberManager.method5252(new class156(var7));
                     }

                     return 1;
                  } else if(var0 == 3651) {
                     var7 = class80.intStack[--class80.intStackSize] == 1;
                     if(class2.clanMemberManager != null) {
                        class2.clanMemberManager.method5252(new class152(var7));
                     }

                     return 1;
                  } else if(var0 == 3652) {
                     var7 = class80.intStack[--class80.intStackSize] == 1;
                     if(class2.clanMemberManager != null) {
                        class2.clanMemberManager.method5252(new class150(var7));
                     }

                     return 1;
                  } else if(var0 == 3653) {
                     var7 = class80.intStack[--class80.intStackSize] == 1;
                     if(class2.clanMemberManager != null) {
                        class2.clanMemberManager.method5252(new class149(var7));
                     }

                     return 1;
                  } else if(var0 == 3654) {
                     var7 = class80.intStack[--class80.intStackSize] == 1;
                     if(class2.clanMemberManager != null) {
                        class2.clanMemberManager.method5252(new class151(var7));
                     }

                     return 1;
                  } else if(var0 == 3655) {
                     if(class2.clanMemberManager != null) {
                        class2.clanMemberManager.method5242();
                     }

                     return 1;
                  } else if(var0 == 3656) {
                     var7 = class80.intStack[--class80.intStackSize] == 1;
                     ContextMenuRow.friendManager.field1194.method5252(new class155(var7));
                     return 1;
                  } else if(var0 == 3657) {
                     var7 = class80.intStack[--class80.intStackSize] == 1;
                     if(class2.clanMemberManager != null) {
                        class2.clanMemberManager.method5252(new class155(var7));
                     }

                     return 1;
                  } else {
                     return 2;
                  }
               }
            } else {
               var3 = class80.intStack[--class80.intStackSize];
               if(class2.clanMemberManager != null && var3 < class2.clanMemberManager.getCount() && ((ClanMember)class2.clanMemberManager.get(var3)).method5166()) {
                  class80.intStack[++class80.intStackSize - 1] = 1;
               } else {
                  class80.intStack[++class80.intStackSize - 1] = 0;
               }

               return 1;
            }
         }
      }
   }
}
