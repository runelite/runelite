import net.runelite.mapping.Export;
import net.runelite.mapping.Hook;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bn")
@Implements("MessageNode")
public class MessageNode extends CacheableNode {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Llh;"
   )
   static IndexedSprite field811;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = 773055171
   )
   @Export("id")
   int id;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 1964894847
   )
   @Export("tick")
   int tick;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -509984571
   )
   @Export("type")
   int type;
   @ObfuscatedName("z")
   @Export("name")
   String name;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lkb;"
   )
   Name field801;
   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "Lkf;"
   )
   class303 field809;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lkf;"
   )
   class303 field807;
   @ObfuscatedName("y")
   @Export("sender")
   String sender;
   @ObfuscatedName("c")
   @Export("value")
   String value;

   @Hook(
      value = "setMessage",
      end = true
   )
   MessageNode(int var1, String var2, String var3, String var4) {
      this.field809 = class303.field3856;
      this.field807 = class303.field3856;
      this.id = BoundingBox2D.method42();
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.method1175();
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;S)V",
      garbageValue = "25207"
   )
   @Export("setMessage")
   @Hook(
      value = "setMessage",
      end = true
   )
   void setMessage(int var1, String var2, String var3, String var4) {
      this.id = BoundingBox2D.method42();
      this.tick = Client.gameCycle;
      this.type = var1;
      this.name = var2;
      this.method1175();
      this.sender = var3;
      this.value = var4;
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1912177303"
   )
   void method1173() {
      this.field809 = class303.field3856;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "1891613917"
   )
   final boolean method1189() {
      if(this.field809 == class303.field3856) {
         this.method1171();
      }

      return this.field809 == class303.field3858;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2076618934"
   )
   void method1171() {
      this.field809 = CacheFile.friendManager.friendContainer.isMember(this.field801)?class303.field3858:class303.field3855;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1917271413"
   )
   void method1172() {
      this.field807 = class303.field3856;
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(B)Z",
      garbageValue = "0"
   )
   final boolean method1185() {
      if(this.field807 == class303.field3856) {
         this.method1174();
      }

      return this.field807 == class303.field3858;
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1415072439"
   )
   void method1174() {
      this.field807 = CacheFile.friendManager.ignoreContainer.isMember(this.field801)?class303.field3858:class303.field3855;
   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "789314719"
   )
   final void method1175() {
      if(this.name != null) {
         this.field801 = new Name(WorldMapData.method357(this.name), DecorativeObject.loginType);
      } else {
         this.field801 = null;
      }

   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Ljr;I)V",
      garbageValue = "-702192265"
   )
   public static void method1197(IndexDataBase var0) {
      Varbit.varbit_ref = var0;
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "([BIIB)Ljava/lang/String;",
      garbageValue = "23"
   )
   public static String method1177(byte[] var0, int var1, int var2) {
      StringBuilder var3 = new StringBuilder();

      for(int var4 = var1; var4 < var2 + var1; var4 += 3) {
         int var5 = var0[var4] & 255;
         var3.append(class317.field3927[var5 >>> 2]);
         if(var4 < var2 - 1) {
            int var6 = var0[var4 + 1] & 255;
            var3.append(class317.field3927[(var5 & 3) << 4 | var6 >>> 4]);
            if(var4 < var2 - 2) {
               int var7 = var0[var4 + 2] & 255;
               var3.append(class317.field3927[(var6 & 15) << 2 | var7 >>> 6]).append(class317.field3927[var7 & 63]);
            } else {
               var3.append(class317.field3927[(var6 & 15) << 2]).append("=");
            }
         } else {
            var3.append(class317.field3927[(var5 & 3) << 4]).append("==");
         }
      }

      return var3.toString();
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-1333516566"
   )
   public static int method1176(int var0, int var1) {
      int var2;
      for(var2 = 0; var1 > 0; --var1) {
         var2 = var2 << 1 | var0 & 1;
         var0 >>>= 1;
      }

      return var2;
   }
}
