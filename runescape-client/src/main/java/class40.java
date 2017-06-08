import java.net.URL;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ac")
public class class40 {
   @ObfuscatedName("f")
   public static final class40 field539;
   @ObfuscatedName("n")
   public static final class40 field540;
   @ObfuscatedName("i")
   public static final class40 field541;
   @ObfuscatedName("j")
   public static final class40 field542;
   @ObfuscatedName("m")
   public final String field543;
   @ObfuscatedName("p")
   public static final class40 field544;

   @ObfuscatedName("ip")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "773529694"
   )
   static void method543() {
      for(WidgetNode var0 = (WidgetNode)Client.componentTable.method3548(); var0 != null; var0 = (WidgetNode)Client.componentTable.method3556()) {
         int var1 = var0.id;
         if(class73.method1095(var1)) {
            boolean var2 = true;
            Widget[] var3 = Widget.widgets[var1];

            int var4;
            for(var4 = 0; var4 < var3.length; ++var4) {
               if(var3[var4] != null) {
                  var2 = var3[var4].hasScript;
                  break;
               }
            }

            if(!var2) {
               var4 = (int)var0.hash;
               Widget var5 = class177.method3390(var4);
               if(var5 != null) {
                  CombatInfo1.method1515(var5);
               }
            }
         }
      }

   }

   static {
      field540 = new class40("details");
      field544 = new class40("compositemap");
      field541 = new class40("compositetexture");
      field542 = new class40("area");
      field539 = new class40("labels");
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(CII)I",
      garbageValue = "-854701097"
   )
   static int method544(char var0, int var1) {
      int var2 = var0 << 4;
      if(Character.isUpperCase(var0) || Character.isTitleCase(var0)) {
         var0 = Character.toLowerCase(var0);
         var2 = (var0 << 4) + 1;
      }

      return var2;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(S)Z",
      garbageValue = "26330"
   )
   @Export("loadWorlds")
   static boolean loadWorlds() {
      try {
         if(class64.worldServersDownload == null) {
            class64.worldServersDownload = new class77(GameEngine.field678, new URL(class149.field2213));
         } else {
            byte[] var0 = class64.worldServersDownload.method1484();
            if(var0 != null) {
               Buffer var1 = new Buffer(var0);
               World.field1297 = var1.readUnsignedShort();
               World.worldList = new World[World.field1297];

               World var3;
               for(int var2 = 0; var2 < World.field1297; var3.index = var2++) {
                  var3 = World.worldList[var2] = new World();
                  var3.id = var1.readUnsignedShort();
                  var3.mask = var1.readInt();
                  var3.address = var1.readString();
                  var3.activity = var1.readString();
                  var3.location = var1.readUnsignedByte();
                  var3.playerCount = var1.readShort();
               }

               class112.method2093(World.worldList, 0, World.worldList.length - 1, World.field1294, World.field1299);
               class64.worldServersDownload = null;
               return true;
            }
         }
      } catch (Exception var4) {
         var4.printStackTrace();
         class64.worldServersDownload = null;
      }

      return false;
   }

   class40(String var1) {
      this.field543 = var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SIIB)V",
      garbageValue = "111"
   )
   static void method546(String[] var0, short[] var1, int var2, int var3) {
      if(var2 < var3) {
         int var4 = (var3 + var2) / 2;
         int var5 = var2;
         String var6 = var0[var4];
         var0[var4] = var0[var3];
         var0[var3] = var6;
         short var7 = var1[var4];
         var1[var4] = var1[var3];
         var1[var3] = var7;

         for(int var8 = var2; var8 < var3; ++var8) {
            if(var6 == null || var0[var8] != null && var0[var8].compareTo(var6) < (var8 & 1)) {
               String var9 = var0[var8];
               var0[var8] = var0[var5];
               var0[var5] = var9;
               short var10 = var1[var8];
               var1[var8] = var1[var5];
               var1[var5++] = var10;
            }
         }

         var0[var3] = var0[var5];
         var0[var5] = var6;
         var1[var3] = var1[var5];
         var1[var5] = var7;
         method546(var0, var1, var2, var5 - 1);
         method546(var0, var1, var5 + 1, var3);
      }

   }
}
