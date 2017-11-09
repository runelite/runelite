import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ep")
@Implements("Tile")
public final class Tile extends Node {
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 1767189463
   )
   @Export("canvasWidth")
   public static int canvasWidth;
   @ObfuscatedName("cs")
   @ObfuscatedSignature(
      signature = "Liy;"
   )
   static IndexData field1838;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -351644251
   )
   @Export("plane")
   int plane;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -971591563
   )
   @Export("x")
   int x;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -1764460159
   )
   @Export("y")
   int y;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -167067815
   )
   @Export("renderLevel")
   int renderLevel;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Led;"
   )
   @Export("paint")
   SceneTilePaint paint;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Ldc;"
   )
   @Export("overlay")
   SceneTileModel overlay;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lea;"
   )
   @Export("wallObject")
   WallObject wallObject;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Leh;"
   )
   @Export("decorativeObject")
   DecorativeObject decorativeObject;
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Ldd;"
   )
   @Export("groundObject")
   GroundObject groundObject;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Ldw;"
   )
   @Export("itemLayer")
   ItemLayer itemLayer;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1929168943
   )
   @Export("entityCount")
   int entityCount;
   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "[Lex;"
   )
   @Export("objects")
   GameObject[] objects;
   @ObfuscatedName("y")
   @Export("entityFlags")
   int[] entityFlags;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = 154143411
   )
   @Export("flags")
   int flags;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 1440094721
   )
   @Export("physicalLevel")
   int physicalLevel;
   @ObfuscatedName("t")
   @Export("draw")
   boolean draw;
   @ObfuscatedName("h")
   @Export("visible")
   boolean visible;
   @ObfuscatedName("u")
   @Export("drawEntities")
   boolean drawEntities;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1211132049
   )
   @Export("wallCullDirection")
   int wallCullDirection;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -1613542171
   )
   @Export("wallUncullDirection")
   int wallUncullDirection;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1420550379
   )
   @Export("wallCullOppositeDirection")
   int wallCullOppositeDirection;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 2010500783
   )
   @Export("wallDrawFlags")
   int wallDrawFlags;
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lep;"
   )
   @Export("bridge")
   Tile bridge;

   Tile(int var1, int var2, int var3) {
      this.objects = new GameObject[5];
      this.entityFlags = new int[5];
      this.flags = 0;
      this.renderLevel = this.plane = var1;
      this.x = var2;
      this.y = var3;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lfv;Lgd;B)Lgd;",
      garbageValue = "2"
   )
   static final IterableHashTable method2607(Buffer var0, IterableHashTable var1) {
      int var2 = var0.readUnsignedByte();
      int var3;
      if(var1 == null) {
         var3 = class163.method3173(var2);
         var1 = new IterableHashTable(var3);
      }

      for(var3 = 0; var3 < var2; ++var3) {
         boolean var4 = var0.readUnsignedByte() == 1;
         int var5 = var0.read24BitInt();
         Object var6;
         if(var4) {
            var6 = new ObjectNode(var0.readString());
         } else {
            var6 = new IntegerNode(var0.readInt());
         }

         var1.put((Node)var6, (long)var5);
      }

      return var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)[Lis;",
      garbageValue = "-1377051789"
   )
   public static class235[] method2610() {
      return new class235[]{class235.field3221, class235.field3225, class235.field3219, class235.field3220, class235.field3217, class235.field3224, class235.field3222, class235.field3223};
   }

   @ObfuscatedName("if")
   @ObfuscatedSignature(
      signature = "(Lhk;IIB)V",
      garbageValue = "42"
   )
   static final void method2608(Widget var0, int var1, int var2) {
      if(Client.field1022 == null && !Client.isMenuOpen) {
         if(var0 != null) {
            Widget var5 = var0;
            int var7 = Preferences.getWidgetConfig(var0);
            int var6 = var7 >> 17 & 7;
            int var8 = var6;
            Widget var4;
            int var9;
            if(var6 == 0) {
               var4 = null;
            } else {
               var9 = 0;

               while(true) {
                  if(var9 >= var8) {
                     var4 = var5;
                     break;
                  }

                  var5 = PendingSpawn.method1612(var5.parentId);
                  if(var5 == null) {
                     var4 = null;
                     break;
                  }

                  ++var9;
               }
            }

            Widget var10 = var4;
            if(var4 == null) {
               var10 = var0.dragParent;
            }

            if(var10 != null) {
               Client.field1022 = var0;
               var5 = var0;
               var7 = Preferences.getWidgetConfig(var0);
               var6 = var7 >> 17 & 7;
               var8 = var6;
               if(var6 == 0) {
                  var4 = null;
               } else {
                  var9 = 0;

                  while(true) {
                     if(var9 >= var8) {
                        var4 = var5;
                        break;
                     }

                     var5 = PendingSpawn.method1612(var5.parentId);
                     if(var5 == null) {
                        var4 = null;
                        break;
                     }

                     ++var9;
                  }
               }

               var10 = var4;
               if(var4 == null) {
                  var10 = var0.dragParent;
               }

               Client.field1023 = var10;
               Client.field1024 = var1;
               Client.field1087 = var2;
               ScriptVarType.field225 = 0;
               Client.field1063 = false;
               int var11 = Client.menuOptionCount - 1;
               if(var11 != -1) {
                  class54.method862(var11);
               }

               return;
            }
         }

      }
   }

   @ObfuscatedName("jy")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)Z",
      garbageValue = "10"
   )
   @Export("isIgnored")
   static boolean isIgnored(String var0) {
      if(var0 == null) {
         return false;
      } else {
         String var1 = PacketBuffer.method3598(var0, class60.field718);

         for(int var2 = 0; var2 < Client.ignoreCount; ++var2) {
            Ignore var3 = Client.ignores[var2];
            if(var1.equalsIgnoreCase(PacketBuffer.method3598(var3.name, class60.field718))) {
               return true;
            }

            if(var1.equalsIgnoreCase(PacketBuffer.method3598(var3.previousName, class60.field718))) {
               return true;
            }
         }

         return false;
      }
   }
}
